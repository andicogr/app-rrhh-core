package com.business.rrhh.module.salary.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmployeeRequest {

    @NotNull
    private Integer id;

}
