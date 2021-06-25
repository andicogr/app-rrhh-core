package com.business.rrhh.module.login.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import com.business.rrhh.util.model.api.StateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class UserUpdateRequest {

    private String password;

    @Valid
    private StateRequest state;

    @Valid
    private List<CompanyRequest> companies;

}
