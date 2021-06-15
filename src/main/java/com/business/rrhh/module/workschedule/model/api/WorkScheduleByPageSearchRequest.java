package com.business.rrhh.module.workschedule.model.api;

import com.business.rrhh.util.model.api.PageSearch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkScheduleByPageSearchRequest extends PageSearch {

    private Integer companyId;
    private String name;
    private Boolean active;

}
