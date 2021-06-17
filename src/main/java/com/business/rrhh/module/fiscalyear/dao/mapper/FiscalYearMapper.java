package com.business.rrhh.module.fiscalyear.dao.mapper;

import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.module.fiscalyear.model.database.FiscalYearEntity;
import com.business.rrhh.module.fiscalyear.state.FiscalYearStates;

import static java.util.Objects.nonNull;

public class FiscalYearMapper {

    public static FiscalYearEntity mapToEntity(FiscalYear business) {

        String stateCode = nonNull(business.getState()) ? business.getState().getCode() : null;

        return FiscalYearEntity.builder()
                .id(business.getId())
                .state(stateCode)
                .year(business.getYear())
                .build();

    }

    public static FiscalYear mapToBusiness(FiscalYearEntity entity) {

        return FiscalYear.builder()
                .id(entity.getId())
                .year(entity.getYear())
                .state(FiscalYearStates.getByCode(entity.getState()).buildState())
                .build();

    }

}
