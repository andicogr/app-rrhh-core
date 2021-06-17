package com.business.rrhh.module.fiscalyear.controller;

import com.business.rrhh.module.fiscalyear.controller.mapper.FiscalYearMapper;
import com.business.rrhh.module.fiscalyear.model.api.*;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.module.fiscalyear.service.FiscalYearService;
import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.util.PageResponse;
import com.business.rrhh.util.controller.mapper.StateMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/fiscal-years")
public class FiscalYearController {

    private FiscalYearService service;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<FiscalYearSearchResponse> getByPage(@Valid FiscalYearByPageSearchRequest searchRequest) {

        return PageResponse.of(
                service.getByPage(FiscalYearMapper.mapToBusiness(searchRequest), searchRequest.buildPageable())
                        .map(FiscalYearMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<FiscalYearSearchResponse> getAll(String state) {


        FiscalYear fiscalYear = FiscalYear.builder().state(StateMapper.mapToState(state)).build();

        return service.getAll(fiscalYear).stream()
                .map(FiscalYearMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public FiscalYearResponse getById(@PathVariable Integer id) {

        return FiscalYearMapper.mapToResponse(service.getById(id));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public FiscalYearResponse create(@RequestBody @Valid FiscalYearCreateRequest createRequest) {

        return FiscalYearMapper.mapToIdResponse(service.save(FiscalYearMapper.mapToBusiness(createRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid FiscalYearUpdateRequest updateRequest) {

        service.updateById(FiscalYearMapper.mapToBusiness(id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @ResponseBody
    @PostMapping(value = "/{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activate(@PathVariable Integer id) {

        service.activate(id);

    }

    @ResponseBody
    @PostMapping(value = "/{id}/close")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void close(@PathVariable Integer id) {

        service.close(id);

    }

}
