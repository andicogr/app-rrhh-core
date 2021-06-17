package com.business.rrhh.module.afp.dao.mapper;

import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.module.fiscalyear.model.database.FiscalYearEntity;

public class FiscalYearMapper {

    public static FiscalYear mapToBusiness(FiscalYearEntity entity) {

        return FiscalYear.builder()
                .id(entity.getId())
                .year(entity.getYear())
                .build();

    }

    public static FiscalYearEntity mapToEntity(FiscalYear business) {

        return FiscalYearEntity.builder()
                .id(business.getId())
                .year(business.getYear())
                .build();
    }

}
