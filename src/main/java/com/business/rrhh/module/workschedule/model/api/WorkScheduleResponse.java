package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkScheduleResponse {

    private Integer id;
    private CompanyResponse company;
    private String name;
    private Integer openingTolerance;
    private Integer departureTolerance;
    private Boolean active;

}
