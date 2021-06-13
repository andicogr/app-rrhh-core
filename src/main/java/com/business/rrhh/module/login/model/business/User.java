package com.business.rrhh.module.login.model.business;

import com.business.rrhh.module.company.model.business.Company;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    private Integer id;

    private String username;

    private String password;

    private String status;

    private List<Company> companies;

}
