package com.business.rrhh.module.employee.model.api.systempension;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AfpRequest {

    @NotNull
    private Integer id;

}
