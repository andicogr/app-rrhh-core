package com.business.rrhh.module.login.model.api;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String status;

    @Valid
    @NotNull
    private List<CompanyRequest> companies;

}
