package com.business.rrhh.module.login.model.api;

import com.business.rrhh.util.api.PageSearch;
import lombok.Data;

@Data
public class UserByPageSearchRequest extends PageSearch {

    private String username;

    private String status;

    private Integer[] companyIds;

}
