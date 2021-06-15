package com.business.rrhh.module.salary.service;

import com.business.rrhh.config.BasicSalaryConfig;
import com.business.rrhh.config.FamilyAllowanceConfig;
import com.business.rrhh.module.salary.dao.SalaryDao;
import com.business.rrhh.module.salary.error.SalaryException;
import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.module.salary.state.SalaryStates;
import com.business.rrhh.util.DateUtil;
import com.business.rrhh.util.FamilyAllowanceType;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class SalaryService {

    private final BasicSalaryConfig basicSalaryConfig;
    private final FamilyAllowanceConfig familyAllowanceConfig;
    private final SalaryDao salaryDao;

    public Page<Salary> getByPage(Salary salary, PageRequest pageRequest) {

        return salaryDao.getByPage(salary, pageRequest);

    }

    public List<Salary> getAll(Salary salary) {

        return salaryDao.getAll(salary);

    }

    public Salary getById(Integer id) {

        return salaryDao.getById(id);

    }

    public Salary save(Salary salary) {

        this.validateSalary(salary);

        salary.setState(SalaryStates.DRAFT.buildState());
        salary.setNetAmount(this.calculateNetSalary(salary));

        return salaryDao.save(salary);

    }

    public void updateById(Salary salary) {

        Salary foundSalary = salaryDao.getById(salary.getId());

        if (foundSalary.isDraft()) {

            foundSalary.setCompany(requireNonNullElse(salary.getCompany(), foundSalary.getCompany()));
            foundSalary.setEmployee(requireNonNullElse(salary.getEmployee(), foundSalary.getEmployee()));
            foundSalary.setAmount(requireNonNullElse(salary.getAmount(), foundSalary.getAmount()));
            foundSalary.setNetAmount(this.calculateNetSalary(foundSalary));
            foundSalary.setFamilyAllowance(requireNonNullElse(salary.getFamilyAllowance(), foundSalary.getFamilyAllowance()));
            foundSalary.setState(requireNonNullElse(salary.getState(), foundSalary.getState()));
            foundSalary.setStartDate(requireNonNullElse(salary.getStartDate(), foundSalary.getStartDate()));
            foundSalary.setEndDate(requireNonNullElse(salary.getEndDate(), foundSalary.getEndDate()));

        } else if (foundSalary.isActive()) {

            foundSalary.setEndDate(requireNonNullElse(salary.getEndDate(), foundSalary.getEndDate()));

        }

        this.validateSalary(foundSalary);

        salaryDao.save(foundSalary);

    }

    public void deleteById(Integer id) {

        Salary salary = salaryDao.getById(id);

        if (!salary.isDraft()) {
            throw SalaryException.CANT_DELETE_NOT_DRAFT_STATE.build();
        }

        salaryDao.deleteById(id);

    }

    private void validateSalary(Salary salary) {

        if (salary.getEndDate() != null
                && (salary.getStartDate().isAfter(salary.getEndDate()) || salary.getStartDate().isEqual(salary.getEndDate()))) {

            throw SalaryException.WRONG_DATES.build();

        }

    }

    private BigDecimal calculateNetSalary(Salary salary) {

        if (salary.getFamilyAllowance() && familyAllowanceConfig.getType().equals(FamilyAllowanceType.CONTAINED_IN_SALARY)) {

            BigDecimal percentage = familyAllowanceConfig.getPercentage().divide(BigDecimal.valueOf(100));

            return salary.getAmount().subtract(percentage.multiply(basicSalaryConfig.getAmount()));

        }

        return salary.getAmount();

    }

    public void activate(Integer id) {

        Salary salary = salaryDao.getById(id);

        if (salaryDao.existsActiveSalaryByEmployee(salary.getEmployee())) {
            throw SalaryException.ACTIVE_SALARY_BY_EMPLOYEE.build();
        }

        salaryDao.findLastValidSalary(salary.getEmployee())
                .ifPresent(lastValidSalary -> {

                    if (salary.isBefore(lastValidSalary)) {

                        throw SalaryException.INVALID_DATE
                                .descriptionParams(DateUtil.format(lastValidSalary.getEndDate()))
                                .build();

                    }

                });

        salary.setState(SalaryStates.ACTIVE.buildState());

        salaryDao.save(salary);

    }

    public void finish(Integer id) {

        Salary salary = salaryDao.getById(id);

        if (Objects.isNull(salary.getEndDate())) {
            throw SalaryException.END_DATE_REQUIRED.build();
        }

        salary.setState(SalaryStates.FINISH.buildState());

        salaryDao.save(salary);

    }

}
