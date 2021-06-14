package com.business.rrhh.module.salary.dao.mapper;

import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeEntity mapToEntity(Employee employee) {

        return EmployeeEntity.builder().id(employee.getId()).build();

    }

    public static Employee mapToEmployee(EmployeeEntity entity) {

        return Employee.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .build();

    }

}
