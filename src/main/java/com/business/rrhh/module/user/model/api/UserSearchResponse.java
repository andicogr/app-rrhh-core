package com.business.rrhh.module.user.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import com.business.rrhh.util.model.api.StateResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSearchResponse {

    private Integer id;
    private String username;
    private String password;
    private StateResponse state;
    private List<CompanyResponse> companies;

}
