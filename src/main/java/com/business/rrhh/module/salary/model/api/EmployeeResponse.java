package com.business.rrhh.module.salary.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class EmployeeResponse {

    private Integer id;
    private String fullName;
}
