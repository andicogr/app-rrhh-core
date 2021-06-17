package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.util.model.api.FiscalYearRequest;
import com.business.rrhh.util.model.api.MonthRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.math.BigDecimal;

@Getter
@Setter
public class AfpCommissionUpdateRequest {

    @Valid
    private FiscalYearRequest fiscalYear;

    @Valid
    private MonthRequest month;

    private BigDecimal commission;

    private BigDecimal contribution;

    private BigDecimal insurance;

    private BigDecimal maximumRemuneration;

    @Valid
    private AfpTypeRequest type;

}
