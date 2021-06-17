package com.business.rrhh.module.salary.controller;

import com.business.rrhh.module.salary.controller.mapper.SalaryMapper;
import com.business.rrhh.module.salary.model.api.*;
import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.module.salary.service.SalaryService;
import com.business.rrhh.util.model.api.PageResponse;
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
@RequestMapping("/salaries")
public class SalaryController {

    private SalaryService service;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<SalarySearchResponse> getByPage(@Valid SalaryByPageSearchRequest searchRequest) {

        return PageResponse.of(
                service.getByPage(SalaryMapper.mapToSalary(searchRequest), searchRequest.buildPageable())
                        .map(SalaryMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<SalarySearchResponse> getAll(String state) {

        Salary salary = Salary.builder().state(StateMapper.mapToState(state)).build();

        return service.getAll(salary).stream()
                .map(SalaryMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public SalaryResponse getById(@PathVariable Integer id) {

        return SalaryMapper.mapToResponse(service.getById(id));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public SalaryResponse create(@RequestBody @Valid SalaryCreateRequest createRequest) {

        return SalaryMapper.mapToIdResponse(service.save(SalaryMapper.mapToSalary(createRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid SalaryUpdateRequest updateRequest) {

        service.updateById(SalaryMapper.mapToSalary(id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @ResponseBody
    @PatchMapping(value = "/{id}/activate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void active(@PathVariable Integer id) {

        service.activate(id);

    }

    @ResponseBody
    @PatchMapping(value = "/{id}/finish")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Integer id) {

        service.finish(id);

    }

}
