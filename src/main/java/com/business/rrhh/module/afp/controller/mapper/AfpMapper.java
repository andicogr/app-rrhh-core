package com.business.rrhh.module.afp.controller.mapper;

import com.business.rrhh.module.afp.model.api.*;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.util.controller.mapper.CompanyMapper;

public class AfpMapper {

    public static Afp mapToBusiness(AfpByPageSearchRequest searchRequest) {

        return Afp.builder()
                .name(searchRequest.getName())
                .active(searchRequest.getActive())
                .build();

    }

    public static AfpSearchResponse mapToResponseSearch(Afp business) {

        return AfpSearchResponse.builder()
                .id(business.getId())
                .active(business.getActive())
                .name(business.getName())
                .build();

    }

    public static Afp mapToBusiness(AfpCreateRequest createRequest) {

        return Afp.builder()
                .name(createRequest.getName())
                .active(createRequest.getActive())
                .build();

    }

    public static AfpResponse mapToIdResponse(Afp business) {

        return AfpResponse.builder()
                .id(business.getId())
                .build();

    }

    public static Afp mapToBusiness(Integer id, AfpUpdateRequest updateRequest) {

        return Afp.builder()
                .id(id)
                .name(updateRequest.getName())
                .active(updateRequest.getActive())
                .build();

    }

    public static AfpResponse mapToResponse(Afp business) {

        return AfpResponse.builder()
                .id(business.getId())
                .active(business.getActive())
                .name(business.getName())
                .build();

    }

    public static Afp mapToBusiness(Integer parentId) {

        return Afp.builder()
                .id(parentId)
                .build();

    }

}
