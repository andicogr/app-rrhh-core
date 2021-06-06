package com.business.rrhh.module.company.controller;

import com.business.rrhh.module.company.controller.mapper.CompanyMapper;
import com.business.rrhh.module.company.model.api.CompanyResponseSearch;
import com.business.rrhh.module.company.model.api.CompanySearchRequest;
import com.business.rrhh.module.company.service.CompanyService;
import com.business.rrhh.util.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    @ResponseBody
    public PageResponse<CompanyResponseSearch> getAll(@Valid CompanySearchRequest companySearchRequest) {

        return PageResponse.of(
                companyService.getAll(CompanyMapper.mapToCompany(companySearchRequest), companySearchRequest.buildPageable())
                        .map(CompanyMapper::mapToResponseSearch)
        );

    }

}
