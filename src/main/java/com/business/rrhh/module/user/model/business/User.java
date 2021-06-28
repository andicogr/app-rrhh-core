package com.business.rrhh.module.user.model.business;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.user.state.UserStates;
import com.business.rrhh.util.model.business.State;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    private Integer id;

    private String username;

    private String password;

    private State state;

    private List<Company> companies;

    public boolean isActive() {
        return this.state.getCode().equals(UserStates.ACTIVE.getCode());
    }

}
