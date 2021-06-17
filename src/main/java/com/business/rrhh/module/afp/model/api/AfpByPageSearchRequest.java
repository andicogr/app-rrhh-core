package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfpByPageSearchRequest extends PageSearch {

    private String name;
    private Boolean active;

}
