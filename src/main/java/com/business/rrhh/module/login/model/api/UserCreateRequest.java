package com.business.rrhh.module.login.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import com.business.rrhh.util.model.api.StateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class UserCreateRequest {

    @NotBlank
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank
    @Size(min = 5, max = 50)
    private String password;

    @Valid
    @NotNull
    private StateRequest state;

    @Valid
    @NotNull
    private List<CompanyRequest> companies;

}
