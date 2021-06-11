package com.business.rrhh.module.login.model.api;

import com.business.rrhh.util.model.api.CompanyResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

    private Integer id;
    private String username;
    private String status;
    private List<CompanyResponse> companies;

}
