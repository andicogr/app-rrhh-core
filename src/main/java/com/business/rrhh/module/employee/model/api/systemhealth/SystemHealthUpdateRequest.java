package com.business.rrhh.module.employee.model.api.systemhealth;

import com.business.rrhh.module.employee.SystemHealthType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.time.LocalDate;

@Getter
@Setter
public class SystemHealthUpdateRequest {

    @Valid
    private SystemHealthType type;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

}
