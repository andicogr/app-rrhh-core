package com.business.rrhh.module.user.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserByPageSearchRequest extends PageSearch {

    private String username;

    private String state;

    private Integer[] companyIds;

}
