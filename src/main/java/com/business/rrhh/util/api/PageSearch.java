package com.business.rrhh.util.api;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class PageSearch {

    @NotNull
    @Min(value = 1)
    private Integer page;

    @NotNull
    @Min(value = 1)
    private Integer size;

    @Valid
    private List<SortSearch> sort;

    public PageRequest buildPageable() {

        Sort sort = Sort.unsorted();

        if (Objects.nonNull(this.sort)) {

            sort = Sort.by(
                    this.sort.stream()
                            .map(SortSearch::toOrder)
                            .collect(Collectors.toList())
            );

        }

        return PageRequest.of(this.page - 1, this.size, sort);

    }

}
