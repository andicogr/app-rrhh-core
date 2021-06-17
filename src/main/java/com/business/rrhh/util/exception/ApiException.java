package com.business.rrhh.util.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
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
