package com.business.rrhh.module.afp.model.business;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.util.model.business.Month;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class AfpCommission {

    private Integer id;

    private FiscalYear fiscalYear;

    private Month month;

    private Afp afp;

    private BigDecimal commission;

    private BigDecimal contribution;

    private BigDecimal insurance;

    private BigDecimal maximumRemuneration;

    private AfpType type;

}
