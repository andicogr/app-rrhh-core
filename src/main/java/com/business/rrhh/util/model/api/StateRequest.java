package com.business.rrhh.util.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StateRequest {

    @NotNull
    private String code;

}
