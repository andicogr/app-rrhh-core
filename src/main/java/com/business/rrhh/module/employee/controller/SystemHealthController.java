package com.business.rrhh.module.employee.controller;

import com.business.rrhh.module.employee.controller.mapper.SystemHealthMapper;
import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthCreateRequest;
import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthResponse;
import com.business.rrhh.module.employee.model.api.systemhealth.SystemHealthUpdateRequest;
import com.business.rrhh.module.employee.service.SystemHealthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/employees/{employeeId}/system-health")
public class SystemHealthController {

    private final SystemHealthService service;

    @ResponseBody
    @GetMapping
    public SystemHealthResponse getByEmployeeId(@PathVariable Integer employeeId) {

        return SystemHealthMapper.mapToResponse(service.getByEmployeeId(employeeId));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable Integer employeeId, @RequestBody @Valid SystemHealthCreateRequest createRequest) {

        service.save(SystemHealthMapper.mapToBusiness(employeeId, createRequest));

    }

    @ResponseBody
    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer employeeId, @RequestBody @Valid SystemHealthUpdateRequest updateRequest) {

        service.update(SystemHealthMapper.mapToBusiness(employeeId, updateRequest));

    }

}
