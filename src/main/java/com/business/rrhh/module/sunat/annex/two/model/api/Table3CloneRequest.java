package com.business.rrhh.module.sunat.annex.two.model.api;

import com.business.rrhh.util.model.api.CompanyRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Table3CloneRequest {

    private CompanyRequest company;

    @NotNull
    private List<Integer> ids;

}
