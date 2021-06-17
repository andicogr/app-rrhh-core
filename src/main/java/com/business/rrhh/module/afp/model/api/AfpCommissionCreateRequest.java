package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.util.model.api.FiscalYearRequest;
import com.business.rrhh.util.model.api.MonthRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class AfpCommissionCreateRequest {

    @Valid
    @NotNull
    private FiscalYearRequest fiscalYear;

    @Valid
    @NotNull
    private MonthRequest month;

    @NotNull
    private BigDecimal commission;

    @NotNull
    private BigDecimal contribution;

    @NotNull
    private BigDecimal insurance;

    @NotNull
    private BigDecimal maximumRemuneration;

    @Valid
    @NotNull
    private AfpTypeRequest type;

}
