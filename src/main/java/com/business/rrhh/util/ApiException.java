package com.business.rrhh.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

@Data
public class ApiException extends RuntimeException {

    private String code;
    private String description;
    private HttpStatus status;
    private List<String> details;

    @Builder
    public ApiException(String code, String description, HttpStatus status, List<String> details) {
        this.code = code;
        this.description = description;

        if (Objects.isNull(status)) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        this.status = status;
        this.details = details;
    }

}
