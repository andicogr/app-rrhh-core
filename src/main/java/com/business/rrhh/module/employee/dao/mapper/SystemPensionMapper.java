package com.business.rrhh.module.employee.dao.mapper;

import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.business.SystemPension;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.module.employee.model.database.SystemPensionEntity;

public class SystemPensionMapper {

    public static SystemPension mapToBusiness(SystemPensionEntity entity) {

        return SystemPension.builder()
                .id(entity.getId())
                .employee(Employee.builder().id(entity.getEmployee().getId()).build())
                .type(entity.getType())
                .startDate(entity.getStartDate())
                .afp(AfpMapper.mapToBusiness(entity.getAfp()))
                .afpType(entity.getAfpType())
                .cusppCode(entity.getCusppCode())
                .build();

    }

    public static SystemPensionEntity mapToEntity(SystemPension business) {

        return SystemPensionEntity.builder()
                .id(business.getId())
                .employee(EmployeeEntity.builder().id(business.getEmployee().getId()).build())
                .type(business.getType())
                .startDate(business.getStartDate())
                .afp(AfpMapper.mapToEntity(business.getAfp()))
                .afpType(business.getAfpType())
                .cusppCode(business.getCusppCode())
                .build();

    }
}
