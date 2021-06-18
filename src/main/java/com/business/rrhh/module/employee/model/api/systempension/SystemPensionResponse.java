package com.business.rrhh.module.employee.model.api.systempension;

import com.business.rrhh.module.afp.model.api.AfpResponse;
import com.business.rrhh.module.afp.model.api.AfpTypeResponse;
import com.business.rrhh.module.employee.SystemPensionType;
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
public class SystemPensionResponse {

    private SystemPensionType type;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate startDate;

    private AfpResponse afp;

    private AfpTypeResponse afpType;

    private String cusppCode;

}
