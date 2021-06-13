package com.business.rrhh.module.employee.model.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Table3Request {

    @NotNull
    private Integer id;

}
