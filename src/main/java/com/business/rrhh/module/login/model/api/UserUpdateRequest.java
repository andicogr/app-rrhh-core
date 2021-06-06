package com.business.rrhh.module.login.model.api;

import lombok.Data;

import javax.validation.Valid;

@Data
public class UserUpdateRequest {

    private String password;

    private String status;

    @Valid
    private CompanyRequest company;

}
