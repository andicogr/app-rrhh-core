package com.business.rrhh.module.company.model.api;

import com.business.rrhh.util.api.PageSearch;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class CompanySearchRequest {

    private String brandName;

    private String ruc;

    private String status;

    @Valid
    @NotNull
    private PageSearch page;

}
