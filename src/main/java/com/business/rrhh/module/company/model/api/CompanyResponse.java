package com.business.rrhh.module.company.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyResponse {

    private Integer id;
    private String brandName;
    private String ruc;
    private String address;
    private String phone;
    private String email;
    private String status;

}
