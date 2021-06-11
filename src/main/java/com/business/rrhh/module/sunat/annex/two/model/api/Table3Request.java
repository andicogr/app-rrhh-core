package com.business.rrhh.module.sunat.annex.two.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Table3Request {

    @NotBlank
    private String code;

    @NotBlank
    private String sunatCode;

    @NotBlank
    private String description;

    @NotBlank
    private String status;

    @Valid
    @NotNull
    private CompanyRequest company;

}
