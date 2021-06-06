package com.business.rrhh.module.login.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserSearchResponse {

    private Integer id;
    private String username;
    private String status;
    private List<CompanyResponse> companies;

}
