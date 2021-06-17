package com.business.rrhh.module.afp.model.api;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AfpCreateRequest {

    @NotBlank
    private String name;

    @NotNull
    private Boolean active;

}
