package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class WorkScheduleUpdateRequest {

    @Valid
    private CompanyRequest company;
    private String name;
    private Integer openingTolerance;
    private Integer departureTolerance;
    private Boolean active;

}
