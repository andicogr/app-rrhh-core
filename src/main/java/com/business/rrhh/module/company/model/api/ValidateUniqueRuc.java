package com.business.rrhh.module.company.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ValidateUniqueRuc {

    @NotNull
    private Integer excludeId;

    @NotBlank
    private String ruc;


}
