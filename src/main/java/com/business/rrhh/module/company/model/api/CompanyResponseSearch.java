package com.business.rrhh.module.company.model.api;

import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponseSearch {

    private Integer id;
    private String brandName;
    private String ruc;
    private String address;
    private StateResponse state;

}
