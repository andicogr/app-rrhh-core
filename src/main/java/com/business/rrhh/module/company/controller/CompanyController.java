package com.business.rrhh.module.company.controller;

import com.business.rrhh.module.company.controller.mapper.CompanyMapper;
import com.business.rrhh.module.company.model.api.*;
import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.company.service.CompanyService;
import com.business.rrhh.module.company.state.CompanyStates;
import com.business.rrhh.util.model.api.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    @ResponseBody
    @GetMapping(params = {"page"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<CompanyResponseSearch> getByPage(@Valid CompanyByPageSearchRequest companySearchRequest) {

        return PageResponse.of(
                companyService.getByPage(CompanyMapper.mapToCompany(companySearchRequest), companySearchRequest.buildPageable())
                        .map(CompanyMapper::mapToResponseSearch)
        );

    }

    @ResponseBody
    @GetMapping
    public List<CompanyResponseSearch> getAll(String state) {

        Company company = Company.builder().state(CompanyStates.getByCode(state).buildState()).build();

        return companyService.getAll(company).stream()
                .map(CompanyMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponse getById(@PathVariable Integer id) {

        return CompanyMapper.mapToResponse(companyService.getById(id));

    }


    @ResponseBody
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponse create(@RequestBody @Valid CompanyCreateRequest companyRequest) {

        return CompanyMapper.mapToResponse(companyService.save(CompanyMapper.mapToCompany(companyRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponse update(@PathVariable Integer id, @RequestBody @Valid CompanyUpdateRequest companyUpdateRequest) {

        return CompanyMapper.mapToResponse(companyService.updateById(CompanyMapper.mapToCompany(id, companyUpdateRequest)));

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {

        companyService.deleteById(id);

    }

}
