package com.business.rrhh.module.login.model.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompanyRequest {

    @NotNull
    private Integer id;

}
