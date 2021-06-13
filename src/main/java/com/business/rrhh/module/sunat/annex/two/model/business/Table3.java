package com.business.rrhh.module.sunat.annex.two.model.business;

import com.business.rrhh.module.company.model.business.Company;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class Table3 {

    private Integer id;
    private String code;
    private String sunatCode;
    private String description;
    private String status;
    private Company company;

    public Table3 clone(Company company) {

        if (Objects.nonNull(company)) {

            return Table3.builder()
                    .code(this.code)
                    .sunatCode(this.sunatCode)
                    .description(this.description)
                    .status(this.status)
                    .company(company)
                    .build();

        } else {

            return Table3.builder()
                    .code("Clone ".concat(this.code))
                    .sunatCode("Clone ".concat(this.sunatCode))
                    .description("Clone ".concat(this.description))
                    .status(this.status)
                    .company(this.company)
                    .build();

        }

    }

}
