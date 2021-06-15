package com.business.rrhh.module.salary.model.business;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.salary.state.SalaryStates;
import com.business.rrhh.util.model.business.State;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Salary {

    private Integer id;
    private Employee employee;
    private BigDecimal amount;
    private BigDecimal netAmount;
    private Boolean familyAllowance;
    private LocalDate startDate;
    private LocalDate endDate;
    private State state;
    private Company company;

    public boolean isDraft() {
        return this.state.getCode().equals(SalaryStates.DRAFT.getCode());
    }

    public boolean isActive() {
        return this.state.getCode().equals(SalaryStates.ACTIVE.getCode());
    }

    public boolean isFinish() {
        return this.state.getCode().equals(SalaryStates.FINISH.getCode());
    }

    public boolean isBefore(Salary salary) {

        return salary.getStartDate().isBefore(salary.getEndDate())
                || salary.getStartDate().isEqual(salary.getEndDate());

    }

}
