package com.business.rrhh.module.user.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ValidateUsername {

    @NotNull
    private Integer excludeUserId;

    @NotBlank
    private String username;

}
