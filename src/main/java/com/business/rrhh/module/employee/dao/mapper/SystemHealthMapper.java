package com.business.rrhh.module.employee.dao.mapper;

import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.business.SystemHealth;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.module.employee.model.database.SystemHealthEntity;

public class SystemHealthMapper {

    public static SystemHealth mapToBusiness(SystemHealthEntity entity) {

        return SystemHealth.builder()
                .id(entity.getId())
                .employee(Employee.builder().id(entity.getEmployee().getId()).build())
                .type(entity.getType())
                .startDate(entity.getStartDate())
                .build();

    }

    public static SystemHealthEntity mapToEntity(SystemHealth business) {

        return SystemHealthEntity.builder()
                .id(business.getId())
                .employee(EmployeeEntity.builder().id(business.getEmployee().getId()).build())
                .type(business.getType())
                .startDate(business.getStartDate())
                .build();

    }
}
