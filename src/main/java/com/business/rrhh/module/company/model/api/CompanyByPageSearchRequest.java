package com.business.rrhh.module.company.model.api;

import com.business.rrhh.util.api.PageSearch;
import lombok.Data;

@Data
public class CompanyByPageSearchRequest extends PageSearch {

    private String brandName;

    private String ruc;

    private String status;

}
