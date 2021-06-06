package com.business.rrhh.util;

public class UpdateObjects {

    public static <T> T requireNonNullElse(T obj, T defaultObj) {
        return (obj != null) ? obj : defaultObj;
    }
}
