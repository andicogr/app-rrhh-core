package com.business.rrhh.util.model.business;

import com.business.rrhh.util.LocaleUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.TextStyle;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Month {

    @Setter(AccessLevel.PRIVATE)
    private java.time.Month code;

    @Setter(AccessLevel.PRIVATE)
    private String name;

    public static Month of(java.time.Month code) {

        Month month = new Month();
        month.setCode(code);
        month.setName(code.getDisplayName(TextStyle.FULL, LocaleUtil.LOCALE));

        return month;

    }

}
