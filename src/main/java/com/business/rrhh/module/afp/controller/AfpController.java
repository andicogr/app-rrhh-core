package com.business.rrhh.module.afp.controller;

import com.business.rrhh.module.afp.controller.mapper.AfpMapper;
import com.business.rrhh.module.afp.model.api.*;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.service.AfpService;
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
@RequestMapping("/afps")
public class AfpController {

    private AfpService service;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<AfpSearchResponse> getByPage(@Valid AfpByPageSearchRequest searchRequest) {

        return PageResponse.of(
                service.getByPage(AfpMapper.mapToBusiness(searchRequest), searchRequest.buildPageable())
                        .map(AfpMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<AfpSearchResponse> getAll(Boolean active) {

        Afp workSchedule = Afp.builder().active(active).build();

        return service.getAll(workSchedule).stream()
                .map(AfpMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public AfpResponse getById(@PathVariable Integer id) {

        return AfpMapper.mapToResponse(service.getById(id));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public AfpResponse create(@RequestBody @Valid AfpCreateRequest createRequest) {

        return AfpMapper.mapToIdResponse(service.save(AfpMapper.mapToBusiness(createRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid AfpUpdateRequest updateRequest) {

        service.updateById(AfpMapper.mapToBusiness(id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

}
