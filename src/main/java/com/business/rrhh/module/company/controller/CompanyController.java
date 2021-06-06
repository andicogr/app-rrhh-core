package com.business.rrhh.module.company.controller;

import com.business.rrhh.module.company.controller.mapper.CompanyMapper;
import com.business.rrhh.module.company.model.api.*;
import com.business.rrhh.module.company.service.CompanyService;
import com.business.rrhh.util.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping(value = "/{id}")
    public CompanyResponse getById(@PathVariable Integer id) {

        return CompanyMapper.mapToResponse(companyService.getById(id));

    }

    @PostMapping
    @ResponseBody
    public CompanyResponse create(@RequestBody @Valid CompanyRequest companyRequest){

        return CompanyMapper.mapToResponse(companyService.save(CompanyMapper.mapToCompany(companyRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    public CompanyResponse update(@PathVariable Integer id, @RequestBody @Valid CompanyUpdateRequest companyUpdateRequest) {

        return CompanyMapper.mapToResponse(companyService.updateById(CompanyMapper.mapToCompany(id, companyUpdateRequest)));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        companyService.deleteById(id);

    }

}
