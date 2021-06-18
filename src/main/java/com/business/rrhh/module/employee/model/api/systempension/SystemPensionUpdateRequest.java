package com.business.rrhh.module.employee.model.api.systempension;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.employee.SystemPensionType;
import com.business.rrhh.module.employee.controller.validations.NotNullDependsOn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.time.LocalDate;

@Getter
@Setter
@NotNullDependsOn.List({
        @NotNullDependsOn(
                fieldName = "type",
                fieldValue = "AFP",
                dependFieldName = "afp"),
        @NotNullDependsOn(
                fieldName = "type",
                fieldValue = "AFP",
                dependFieldName = "afpType"),
        @NotNullDependsOn(
                fieldName = "type",
                fieldValue = "AFP",
                dependFieldName = "cusppCode"),
})
public class SystemPensionUpdateRequest {

    @Valid
    private SystemPensionType type;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @Valid
    private AfpRequest afp;

    @Valid
    private AfpType afpType;

    private String cusppCode;

}
