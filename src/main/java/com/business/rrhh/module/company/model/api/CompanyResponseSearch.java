package com.business.rrhh.module.company.model.api;

import lombok.Data;

@Data
public class CompanyResponseSearch {

    private Integer id;
    private String brandName;
    private String ruc;
    private String address;
    private String status;

}
