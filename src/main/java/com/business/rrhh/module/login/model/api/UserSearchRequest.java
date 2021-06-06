package com.business.rrhh.module.login.model.api;

import com.business.rrhh.util.api.PageSearch;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class UserSearchRequest {

    private String username;

    private String status;

    @Valid
    private CompanyRequest company;

    @Valid
    @NotNull
    private PageSearch page;

}
