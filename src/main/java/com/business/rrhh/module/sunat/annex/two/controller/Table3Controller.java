package com.business.rrhh.module.sunat.annex.two.controller;

import com.business.rrhh.module.sunat.annex.two.controller.mapper.Table3Mapper;
import com.business.rrhh.module.sunat.annex.two.model.api.Table3ByPageSearchRequest;
import com.business.rrhh.module.sunat.annex.two.model.api.Table3CloneRequest;
import com.business.rrhh.module.sunat.annex.two.model.api.Table3SearchResponse;
import com.business.rrhh.module.sunat.annex.two.service.Table3Service;
import com.business.rrhh.util.PageResponse;
import com.business.rrhh.util.controller.mapper.CompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/sunat/annex-2/table-3")
public class Table3Controller {

    private final Table3Service table3Service;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<Table3SearchResponse> getByPage(@Valid Table3ByPageSearchRequest searchByPage) {

        return PageResponse.of(
                table3Service.getByPage(Table3Mapper.mapToTable3(searchByPage), searchByPage.buildPageable())
                        .map(Table3Mapper::mapToResponseSearch)
        );

    }

    @ResponseBody
    @PostMapping(value = "/clone")
    public void clone(@Valid @RequestBody Table3CloneRequest cloneRequest) {

        table3Service.clone(CompanyMapper.mapToCompany(cloneRequest.getCompany()), cloneRequest.getIds());

    }

}
