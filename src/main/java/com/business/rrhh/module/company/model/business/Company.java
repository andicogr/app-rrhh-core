package com.business.rrhh.module.company.model.business;

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

    public CompanyBuilder mutate() {

        return Company.builder()
                .id(this.id)
                .brandName(this.brandName)
                .ruc(this.ruc)
                .status(this.status)
                .email(this.email)
                .address(this.address)
                .phone(this.phone);

    }

}
