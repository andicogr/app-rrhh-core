package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WorkScheduleCreateRequest {

    @Valid
    @NotNull
    private CompanyRequest company;

    @NotBlank
    private String name;

    private Integer openingTolerance;
    private Integer departureTolerance;

    @NotNull
    private Boolean active;

}
