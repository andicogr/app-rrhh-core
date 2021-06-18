package com.business.rrhh.module.employee.controller.mapper;

import com.business.rrhh.module.afp.model.api.AfpTypeResponse;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionCreateRequest;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionResponse;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionUpdateRequest;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.business.SystemPension;

import java.util.Objects;

public class SystemPensionMapper {

    public static SystemPensionResponse mapToResponse(SystemPension business) {

        AfpTypeResponse afpTypeResponse = null;

        if (Objects.nonNull(business.getAfpType())) {
            afpTypeResponse = AfpTypeResponse.of(business.getAfpType());
        }

        return SystemPensionResponse.builder()
                .type(business.getType())
                .startDate(business.getStartDate())
                .afp(AfpMapper.mapToResponse(business.getAfp()))
                .afpType(afpTypeResponse)
                .cusppCode(business.getCusppCode())
                .build();

    }

    public static SystemPension mapToBusiness(Integer employeeId, SystemPensionCreateRequest createRequest) {

        Afp afp = null;

        if (Objects.nonNull(createRequest.getAfp())) {
            afp = Afp.builder().id(createRequest.getAfp().getId()).build();
        }

        return SystemPension.builder()
                .employee(Employee.builder().id(employeeId).build())
                .type(createRequest.getType())
                .startDate(createRequest.getStartDate())
                .afp(afp)
                .afpType(createRequest.getAfpType())
                .cusppCode(createRequest.getCusppCode())
                .build();

    }

    public static SystemPension mapToBusiness(Integer employeeId, SystemPensionUpdateRequest updateRequest) {

        Afp afp = null;

        if (Objects.nonNull(updateRequest.getAfp())) {
            afp = Afp.builder().id(updateRequest.getAfp().getId()).build();
        }

        return SystemPension.builder()
                .employee(Employee.builder().id(employeeId).build())
                .type(updateRequest.getType())
                .startDate(updateRequest.getStartDate())
                .afp(afp)
                .afpType(updateRequest.getAfpType())
                .cusppCode(updateRequest.getCusppCode())
                .build();

    }

}
