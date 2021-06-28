package com.business.rrhh.util.model.api;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class PageSearch {

    private static final String REGEX_GET_ORDER_AND_PARAMETER = "[\\(\\)]";

    @NotNull
    @Min(value = 1)
    private Integer page;

    @NotNull
    @Min(value = 1)
    private Integer size;

    private String[] sort;

    public PageRequest buildPageable() {

        Sort sort = Sort.by(new Sort.Order(Sort.DEFAULT_DIRECTION ,"id"));

        if (Objects.nonNull(this.sort)) {

            List<Sort.Order> orders = Arrays.asList(this.sort)
                    .stream()
                    .map(this::buildOrder)
                    .collect(Collectors.toList());

            sort = Sort.by(orders);
        }

        return PageRequest.of(this.page - 1, this.size, sort);
    }

    private Sort.Order buildOrder(String sortOrder) {

        String[] split = sortOrder.split(REGEX_GET_ORDER_AND_PARAMETER);

        return new Sort.Order(Sort.Direction.valueOf(split[0].toUpperCase()), split[1]);

    }

}
