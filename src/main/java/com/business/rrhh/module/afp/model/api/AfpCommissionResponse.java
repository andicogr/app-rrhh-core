package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.util.model.api.FiscalYearResponse;
import com.business.rrhh.util.model.api.MonthResponse;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class AfpCommissionResponse {

    private Integer id;

    private FiscalYearResponse fiscalYear;

    private MonthResponse month;

    private BigDecimal commission;

    private BigDecimal contribution;

    private BigDecimal insurance;

    private BigDecimal maximumRemuneration;

    private AfpTypeResponse type;

}
