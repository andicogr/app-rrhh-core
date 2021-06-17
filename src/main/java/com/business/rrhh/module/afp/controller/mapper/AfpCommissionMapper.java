package com.business.rrhh.module.afp.controller.mapper;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.afp.model.api.*;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.business.AfpCommission;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.util.controller.mapper.MonthMapper;

import java.util.Objects;

public class AfpCommissionMapper {

    public static AfpCommissionSearchResponse mapToResponseSearch(AfpCommission business) {

        return AfpCommissionSearchResponse.builder()
                .id(business.getId())
                .period(business.getFiscalYear().getYear().toString().concat(" - ").concat(business.getMonth().getName()))
                .type(business.getType().getDescription())
                .contribution(business.getContribution())
                .commission(business.getCommission())
                .insurance(business.getInsurance())
                .maximumRemuneration(business.getMaximumRemuneration())
                .build();

    }

    public static AfpCommissionResponse mapToResponse(AfpCommission business) {

        return AfpCommissionResponse.builder()
                .id(business.getId())
                .fiscalYear(FiscalYearMapper.mapToResponse(business.getFiscalYear()))
                .month(MonthMapper.mapToResponse(business.getMonth()))
                .type(AfpTypeResponse.of(business.getType()))
                .contribution(business.getContribution())
                .commission(business.getCommission())
                .insurance(business.getInsurance())
                .maximumRemuneration(business.getMaximumRemuneration())
                .build();

    }

    public static AfpCommission mapToBusiness(Integer afpId, AfpCommissionCreateRequest createRequest) {

        return AfpCommission.builder()
                .afp(Afp.builder().id(afpId).build())
                .fiscalYear(FiscalYear.builder().id(createRequest.getFiscalYear().getId()).build())
                .month(MonthMapper.mapToBusiness(createRequest.getMonth()))
                .type(createRequest.getType().getCode())
                .commission(createRequest.getCommission())
                .contribution(createRequest.getContribution())
                .insurance(createRequest.getInsurance())
                .maximumRemuneration(createRequest.getMaximumRemuneration())
                .build();

    }

    public static AfpCommission mapToBusiness(Integer afpId, Integer id, AfpCommissionUpdateRequest updateRequest) {

        AfpType afpType = null;

        if (Objects.nonNull(updateRequest.getType())) {

            afpType = updateRequest.getType().getCode();

        }

        return AfpCommission.builder()
                .id(id)
                .afp(Afp.builder().id(afpId).build())
                .fiscalYear(FiscalYearMapper.mapToBusiness(updateRequest.getFiscalYear()))
                .month(MonthMapper.mapToBusiness(updateRequest.getMonth()))
                .type(afpType)
                .commission(updateRequest.getCommission())
                .contribution(updateRequest.getContribution())
                .insurance(updateRequest.getInsurance())
                .maximumRemuneration(updateRequest.getMaximumRemuneration())
                .build();
    }
}
