package com.business.rrhh.module.sunat.annex.two.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Data;

@Data
public class Table3ByPageSearchRequest extends PageSearch {

    private String code;
    private String sunatCode;
    private String description;
    private String status;
    private Integer companyId;

}
