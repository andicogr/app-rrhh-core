package com.business.rrhh.util.controller.mapper;

import com.business.rrhh.util.model.api.MonthRequest;
import com.business.rrhh.util.model.api.MonthResponse;
import com.business.rrhh.util.model.business.Month;

import java.util.Objects;

public class MonthMapper {

    public static MonthResponse mapToResponse(Month month) {

        return MonthResponse.of(month.getCode(), month.getName());

    }

    public static Month mapToBusiness(MonthRequest request) {

        if (Objects.isNull(request)) {
            return null;
        }

        return Month.of(request.getCode());

    }

}
