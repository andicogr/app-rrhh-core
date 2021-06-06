package com.business.rrhh.module.login.model.business;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Company {

    private Integer id;
    private String brandName;
    private String ruc;
    private String status;
    private String email;
    private String address;
    private String phone;

}
