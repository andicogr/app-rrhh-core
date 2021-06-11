package com.business.rrhh.util.model.api;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompanyRequest {

    @NotNull
    private Integer id;

}
