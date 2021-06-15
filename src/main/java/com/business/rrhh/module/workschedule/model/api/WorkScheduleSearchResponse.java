package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkScheduleSearchResponse {

    private Integer id;
    private CompanyResponse company;
    private String name;
    private Integer openingTolerance;
    private Integer departureTolerance;
    private Boolean active;

}
