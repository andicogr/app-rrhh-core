package com.business.rrhh.module.fiscalyear.model.api;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class FiscalYearCreateRequest {

    @NotNull
    @Min(value = 2000)
    @Max(value = 2100)
    private Integer year;

}
