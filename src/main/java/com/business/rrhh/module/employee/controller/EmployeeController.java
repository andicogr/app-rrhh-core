package com.business.rrhh.module.employee.controller;

import com.business.rrhh.module.employee.controller.mapper.EmployeeMapper;
import com.business.rrhh.module.employee.model.api.*;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.service.EmployeeService;
import com.business.rrhh.util.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService service;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<EmployeeSearchResponse> getByPage(@Valid EmployeeByPageSearchRequest searchRequest) {

        return PageResponse.of(
                service.getByPage(EmployeeMapper.mapToEmployee(searchRequest), searchRequest.buildPageable())
                        .map(EmployeeMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<EmployeeSearchResponse> getAll(String status) {

        Employee employee = Employee.builder().status(status).build();

        return service.getAll(employee).stream()
                .map(EmployeeMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public EmployeeResponse getById(@PathVariable Integer id) {

        return EmployeeMapper.mapToResponse(service.getById(id));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse create(@RequestBody @Valid EmployeeCreateRequest createRequest) {

        return EmployeeMapper.mapToIdResponse(service.save(EmployeeMapper.mapToEmployee(createRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid EmployeeUpdateRequest updateRequest) {

        service.updateById(EmployeeMapper.mapToEmployee(id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

}
