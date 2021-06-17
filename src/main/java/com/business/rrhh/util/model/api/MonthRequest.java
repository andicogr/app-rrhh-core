package com.business.rrhh.util.model.api;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.Month;

@Getter
@Setter
public class MonthRequest {

    @NotNull
    private Month code;

}
