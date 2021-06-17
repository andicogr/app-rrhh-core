package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.module.afp.AfpType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AfpTypeRequest {

    @NotNull
    private AfpType code;

}
