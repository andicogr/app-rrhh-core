package com.business.rrhh.module.afp.model.api;

import com.business.rrhh.module.afp.AfpType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AfpTypeResponse {

    @Setter(AccessLevel.PRIVATE)
    private String code;

    @Setter(AccessLevel.PRIVATE)
    private String description;

    public static AfpTypeResponse of(AfpType type) {

        AfpTypeResponse response = new AfpTypeResponse();

        response.setCode(type.name());
        response.setDescription(type.getDescription());

        return response;

    }

}
