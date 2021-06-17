package com.business.rrhh.util.model.api;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
public class PageResponse<T> {

    private List<T> content;

    private Long totalElements;

    private Integer totalPages;

    private Integer pageNumber;

    private Integer elementsInCurrentPage;

    private boolean first;

    private boolean last;

    public static <T> PageResponse of(Page page){

        return PageResponse.<T>builder()
                .content(page.getContent())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .pageNumber(page.getNumber() + 1)
                .elementsInCurrentPage(page.getNumberOfElements())
                .first(page.isFirst())
                .last(page.isLast())
                .build();

    }


}
