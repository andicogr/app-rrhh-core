package com.business.rrhh.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    public static BigDecimal format(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return BigDecimal.valueOf(0).setScale(4, RoundingMode.HALF_UP);
        }

        return bigDecimal.setScale(4, RoundingMode.HALF_UP);
    }

    public static BigDecimal setScale(BigDecimal amount) {
        return amount.setScale(4, RoundingMode.HALF_UP);
    }

}
