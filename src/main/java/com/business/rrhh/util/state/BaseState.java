package com.business.rrhh.util.state;

import com.business.rrhh.util.model.business.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BaseState {

    @Getter
    @Setter(value = AccessLevel.PROTECTED)
    private List<State> statusList;

    public final State getByCode(String code) {

        if (StringUtils.isEmpty(code)) {
            return State.builder().build();
        }

        return statusList.stream()
                .filter(status -> status.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(State.builder().build());

    }

    public State getFirstState() {

        return statusList.stream()
                .filter(State::isFirst)
                .findFirst()
                .get();

    }

}
