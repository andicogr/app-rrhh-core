package com.business.rrhh.module.company.error;

import com.business.rrhh.module.company.state.CompanyStates;
import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.List;

public enum CompanyException {

    COMPANY_NOT_FOUND("0001", "No se encontró la compañia", HttpStatus.NOT_FOUND),
    CANT_DELETE_ACTIVE_STATE("0002", "No se puede elminar una compañia en estado ".concat(CompanyStates.ACTIVE.getDescription()), HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    CompanyException(String code, String description, HttpStatus status) {
        this.code = "COMPANY-".concat(code);
        this.description = description;
        this.status = status;

    }

    public ApiException build() {

        return this.build(null);

    }

    public ApiException build(List<String> detail) {
        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .details(detail)
                .build();
    }

}
