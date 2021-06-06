package com.business.rrhh.util.api;

import lombok.Data;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class SortSearch {

    @NotBlank
    private String name;

    @Valid
    private Order order;

    public Sort.Order toOrder() {

        if (order.name().equalsIgnoreCase(Sort.Direction.ASC.name())) {

            return Sort.Order.asc(this.name);

        } else if (order.name().equalsIgnoreCase(Sort.Direction.DESC.name())) {

            return Sort.Order.desc(this.name);

        }

        return Sort.Order.by(this.name);

    }

}
