package com.business.rrhh.module.sunat.annex.two.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Table3Response {

    private Integer id;
    private String code;
    private String description;
    private CompanyResponse company;
}
