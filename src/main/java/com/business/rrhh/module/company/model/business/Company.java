package com.business.rrhh.module.company.model.business;

import com.business.rrhh.module.company.state.CompanyStates;
import com.business.rrhh.util.model.business.State;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Company {

    private Integer id;
    private String brandName;
    private String ruc;
    private State state;
    private String email;
    private String address;
    private String phone;

    public CompanyBuilder mutate() {

        return Company.builder()
                .id(this.id)
                .brandName(this.brandName)
                .ruc(this.ruc)
                .state(this.state)
                .email(this.email)
                .address(this.address)
                .phone(this.phone);

    }

    public boolean isActive() {
        return this.state.getCode().equals(CompanyStates.ACTIVE.getCode());
    }

}
