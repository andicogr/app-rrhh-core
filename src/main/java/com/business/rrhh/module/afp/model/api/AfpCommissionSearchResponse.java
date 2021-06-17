package com.business.rrhh.module.afp.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AfpCommissionSearchResponse {

    private Integer id;
    private String period;
    private String type;
    private BigDecimal commission;
    private BigDecimal contribution;
    private BigDecimal insurance;
    private BigDecimal maximumRemuneration;

}
