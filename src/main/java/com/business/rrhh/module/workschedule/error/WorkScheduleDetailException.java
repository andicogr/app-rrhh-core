package com.business.rrhh.module.workschedule.error;

import com.business.rrhh.util.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public enum WorkScheduleDetailException {

    NOT_FOUND("0001", "No se encontró el detalle del horario", HttpStatus.NOT_FOUND),
    DAY_OF_WEEK_ALREADY_EXISTS("0002", "Ya existe un registro para este dia de la semana", HttpStatus.CONFLICT);

    private String code;
    private String description;
    private HttpStatus status;

    WorkScheduleDetailException(String code, String description, HttpStatus status) {
        this.code = "WORK-SCHEDULE-DETAIL-".concat(code);
        this.description = description;
        this.status = status;

    }

    public ApiException build() {

        return this.build(null);

    }

    public ApiException build(String... details) {
        return ApiException.builder()
                .code(this.code)
                .description(this.description)
                .status(this.status)
                .details(details != null ? Arrays.asList(details) : null)
                .build();
    }

    public ApiException.ApiExceptionBuilder descriptionParams(String... params) {
        return ApiException.builder()
                .code(this.code)
                .description(String.format(this.description, params))
                .status(this.status)
                .details(null);
    }

}
