package com.business.rrhh.module.afp.controller.mapper;

import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.util.model.api.FiscalYearRequest;
import com.business.rrhh.util.model.api.FiscalYearResponse;

import java.util.Objects;

public class FiscalYearMapper {

    public static FiscalYearResponse mapToResponse(FiscalYear fiscalYear) {

        return FiscalYearResponse.of(fiscalYear.getId(), fiscalYear.getYear());

    }

    public static FiscalYear mapToBusiness(FiscalYearRequest request) {

        if (Objects.isNull(request)) {
            return null;
        }

        return FiscalYear.builder().id(request.getId()).build();

    }

}
