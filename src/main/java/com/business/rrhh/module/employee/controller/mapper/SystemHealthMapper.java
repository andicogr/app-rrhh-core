package com.business.rrhh.module.employee.controller.mapper;

import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthCreateRequest;
import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthResponse;
import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthUpdateRequest;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.business.SystemHealth;

public class SystemHealthMapper {

    public static SystemHealthResponse mapToResponse(SystemHealth business) {

        return SystemHealthResponse.builder()
                .type(business.getType())
                .startDate(business.getStartDate())
                .build();

    }

    public static SystemHealth mapToBusiness(Integer employeeId, SystemHealthCreateRequest createRequest) {

        return SystemHealth.builder()
                .employee(Employee.builder().id(employeeId).build())
                .type(createRequest.getType())
                .startDate(createRequest.getStartDate())
                .build();

    }

    public static SystemHealth mapToBusiness(Integer employeeId, SystemHealthUpdateRequest updateRequest) {

        return SystemHealth.builder()
                .employee(Employee.builder().id(employeeId).build())
                .type(updateRequest.getType())
                .startDate(updateRequest.getStartDate())
                .build();

    }

}
