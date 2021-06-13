package com.business.rrhh.module.employee.service;

import com.business.rrhh.module.employee.dao.EmployeeDao;
import com.business.rrhh.module.employee.error.EmployeeException;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.state.EmployeeStates;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeDao employeeDao;

    public Page<Employee> getByPage(Employee employee, PageRequest pageRequest) {

        return employeeDao.getByPage(employee, pageRequest);
    }

    public List<Employee> getAll(Employee employee) {

        return employeeDao.getAll(employee);

    }

    public Employee getById(Integer id) {

        return employeeDao.getById(id);
    }

    public Employee save(Employee employee) {

        this.validateEmployee(employee);

        employee.setState(EmployeeStates.instance.getFirstState());

        return employeeDao.save(employee);

    }

    public void updateById(Employee employee) {

        this.validateEmployee(employee);

        Employee foundEmployee = employeeDao.getById(employee.getId());
        foundEmployee.setFirstName(requireNonNullElse(employee.getFirstName(), foundEmployee.getFirstName()));
        foundEmployee.setSecondName(requireNonNullElse(employee.getSecondName(), foundEmployee.getSecondName()));
        foundEmployee.setPaternalName(requireNonNullElse(employee.getPaternalName(), foundEmployee.getPaternalName()));
        foundEmployee.setMaternalName(requireNonNullElse(employee.getMaternalName(), foundEmployee.getMaternalName()));
        foundEmployee.setState(requireNonNullElse(employee.getState(), foundEmployee.getState()));
        foundEmployee.setDocumentType(requireNonNullElse(employee.getDocumentType(), foundEmployee.getDocumentType()));
        foundEmployee.setDocumentNumber(requireNonNullElse(employee.getDocumentNumber(), foundEmployee.getDocumentNumber()));
        foundEmployee.setEmail(requireNonNullElse(employee.getEmail(), foundEmployee.getEmail()));
        foundEmployee.setWorkPhone(requireNonNullElse(employee.getWorkPhone(), foundEmployee.getWorkPhone()));
        foundEmployee.setMobilePhone(requireNonNullElse(employee.getMobilePhone(), foundEmployee.getMobilePhone()));
        foundEmployee.setBornDate(requireNonNullElse(employee.getBornDate(), foundEmployee.getBornDate()));

        employeeDao.save(foundEmployee);

    }

    public void deleteById(Integer id) {

        employeeDao.deleteById(id);

    }

    private void validateEmployee(Employee employee) {

        employeeDao.findByDocumentTypeAndNumber(employee)
                .ifPresent(foundEmployee -> {

                    if (Objects.isNull(employee.getId())) {

                        throw EmployeeException.DOC_NUMBER_AND_DOC_TYPE_ALREADY_USED.build();

                    } else if (Objects.nonNull(employee.getId())
                            && foundEmployee.getId().intValue() != employee.getId().intValue()) {

                        throw EmployeeException.DOC_NUMBER_AND_DOC_TYPE_ALREADY_USED.build();

                    }

                });

    }

}
