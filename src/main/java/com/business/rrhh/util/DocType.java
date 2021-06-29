package com.business.rrhh.util;

public enum DocType {

    DNI("01"),
    CE("04"),
    PAS("07");

    String sunatCode;

    DocType(String sunatCode) {
        this.sunatCode = sunatCode;
    }
}
