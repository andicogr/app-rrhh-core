package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.Data;

import javax.validation.Valid;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class WorkScheduleDetailUpdateRequest {

    @Valid
    private DayOfWeek dayOfWeek;

    @JsonFormat(pattern = "HH:mm:ss")
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime openingTime;

    @JsonFormat(pattern = "HH:mm:ss")
    @JsonSerialize(using = LocalTimeSerializer.class)
    private LocalTime departureTime;

}
