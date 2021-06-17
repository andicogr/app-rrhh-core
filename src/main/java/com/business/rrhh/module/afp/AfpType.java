package com.business.rrhh.module.afp;

import lombok.Getter;

public enum AfpType {

    MIXED("Mixta"),
    FLUX("Flujo");

    @Getter
    String description;

    AfpType(String description) {
        this.description = description;
    }

}
