package com.business.rrhh.module.company.model.api;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class CompanyUpdateRequest {

    @NotBlank
    @Size(max = 200)
    private String brandName;

    @NotBlank
    @Size(max = 11)
    @Pattern(regexp = "^[0-9]*$")
    private String ruc;

    @Size(max = 200)
    private String address;

    @Size(max = 20)
    @Pattern(regexp = "^[0-9+ ]*$")
    private String phone;

    @Email
    @Size(max = 64)
    private String email;

}
