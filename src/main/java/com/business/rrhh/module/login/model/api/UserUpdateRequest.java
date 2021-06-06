package com.business.rrhh.module.login.model.api;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class UserUpdateRequest {

    private String password;

    private String status;

    @Valid
    private List<CompanyRequest> companies;

}
