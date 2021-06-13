package com.business.rrhh.module.company.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyByPageSearchRequest extends PageSearch {

    private String brandName;

    private String ruc;

    private String status;

}
