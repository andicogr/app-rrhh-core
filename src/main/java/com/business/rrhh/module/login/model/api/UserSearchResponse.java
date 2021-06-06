package com.business.rrhh.module.login.model.api;

import lombok.Data;

@Data
public class UserSearchResponse {

    private Integer id;
    private String username;
    private String status;
    private CompanyResponse company;

}
