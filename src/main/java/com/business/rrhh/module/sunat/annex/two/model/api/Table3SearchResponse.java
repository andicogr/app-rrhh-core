package com.business.rrhh.module.sunat.annex.two.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Table3SearchResponse {

    private Integer id;
    private String code;
    private String sunatCode;
    private String description;
    private String status;
    private CompanyResponse company;

}
