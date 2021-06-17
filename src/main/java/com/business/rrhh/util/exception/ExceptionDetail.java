package com.business.rrhh.util.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDetail {

    private String code;
    private String description;
    private List<String> details;

}
