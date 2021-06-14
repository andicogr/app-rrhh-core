package com.business.rrhh.module.salary.controller.mapper;

import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.salary.model.api.EmployeeRequest;
import com.business.rrhh.module.salary.model.api.EmployeeResponse;

import java.util.Objects;

class EmployeeMapper {

    public static Employee mapToEmployee(Integer employeeId) {

        if (Objects.isNull(employeeId)) {
            return null;
        }

        return Employee.builder().id(employeeId).build();

    }

    public static EmployeeResponse mapToResponse(Employee employee) {

        return EmployeeResponse.of(employee.getId(), employee.getFullName());

    }

    public static Employee mapToEmployee(EmployeeRequest employee) {

        if (Objects.isNull(employee)) {
            return null;
        }

        return Employee.builder().id(employee.getId()).build();

    }

}
