package com.business.rrhh.module.fiscalyear.controller.mapper;

import com.business.rrhh.module.fiscalyear.model.api.*;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.util.controller.mapper.StateMapper;

public class FiscalYearMapper {

    public static FiscalYear mapToBusiness(FiscalYearByPageSearchRequest searchRequest) {

        return FiscalYear.builder()
                .year(searchRequest.getYear())
                .state(StateMapper.mapToState(searchRequest.getState()))
                .build();

    }

    public static FiscalYearSearchResponse mapToResponseSearch(FiscalYear business) {

        return FiscalYearSearchResponse.builder()
                .id(business.getId())
                .state(StateMapper.mapToResponse(business.getState()))
                .year(business.getYear())
                .build();

    }


    public static FiscalYearResponse mapToResponse(FiscalYear business) {

        return FiscalYearResponse.builder()
                .id(business.getId())
                .state(StateMapper.mapToResponse(business.getState()))
                .year(business.getYear())
                .build();

    }

    public static FiscalYear mapToBusiness(FiscalYearCreateRequest createRequest) {

        return FiscalYear.builder()
                .year(createRequest.getYear())
                .build();

    }

    public static FiscalYearResponse mapToIdResponse(FiscalYear business) {

        return FiscalYearResponse.builder()
                .id(business.getId())
                .build();

    }

    public static FiscalYear mapToBusiness(Integer id, FiscalYearUpdateRequest updateRequest) {

        return FiscalYear.builder()
                .id(id)
                .year(updateRequest.getYear())
                .build();

    }

    public static FiscalYear mapToBusiness(Integer parentId) {

        return FiscalYear.builder()
                .id(parentId)
                .build();

    }

}
