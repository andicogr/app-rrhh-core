package com.business.rrhh.module.employee.controller;

import com.business.rrhh.module.employee.controller.mapper.SystemPensionMapper;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionCreateRequest;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionResponse;
import com.business.rrhh.module.employee.model.api.systempension.SystemPensionUpdateRequest;
import com.business.rrhh.module.employee.service.SystemPensionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/employees/{employeeId}/system-pension")
public class SystemPensionController {

    private final SystemPensionService service;

    @ResponseBody
    @GetMapping
    public SystemPensionResponse getByEmployeeId(@PathVariable Integer employeeId) {

        return SystemPensionMapper.mapToResponse(service.getByEmployeeId(employeeId));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@PathVariable Integer employeeId, @RequestBody @Valid SystemPensionCreateRequest createRequest) {

        service.save(SystemPensionMapper.mapToBusiness(employeeId, createRequest));

    }

    @ResponseBody
    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer employeeId, @RequestBody @Valid SystemPensionUpdateRequest updateRequest) {

        service.update(SystemPensionMapper.mapToEmployee(employeeId, updateRequest));

    }

}
