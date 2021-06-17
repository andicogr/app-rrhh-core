package com.business.rrhh.module.afp.controller;

import com.business.rrhh.module.afp.controller.mapper.AfpCommissionMapper;
import com.business.rrhh.module.afp.controller.mapper.AfpMapper;
import com.business.rrhh.module.afp.model.api.*;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.service.AfpCommissionService;
import com.business.rrhh.module.afp.service.AfpService;
import com.business.rrhh.util.PageResponse;
import com.business.rrhh.util.model.api.PageSearch;
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
    private AfpCommissionService commissionService;

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


    @ResponseBody
    @GetMapping(value = "/{afpId}/commissions")
    public List<AfpCommissionSearchResponse> getCommissionsByPage(@PathVariable Integer afpId, @Valid PageSearch pageSearch) {

        Afp afp = Afp.builder().id(afpId).build();

        return commissionService.getByPage(afp, pageSearch.buildPageable()).stream()
                .map(AfpCommissionMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @PostMapping(value = "/{afpId}/commissions")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCommission(@PathVariable Integer afpId,
                             @RequestBody @Valid AfpCommissionCreateRequest createRequest) {

        commissionService.save(AfpCommissionMapper.mapToBusiness(afpId, createRequest));

    }


    @ResponseBody
    @GetMapping(value = "/{afpId}/commissions/{id}")
    public AfpCommissionResponse getDetail(@PathVariable Integer afpId, @PathVariable Integer id) {

        return AfpCommissionMapper.mapToResponse(commissionService.getById(afpId, id));

    }

    @ResponseBody
    @PatchMapping(value = "/{afpId}/commissions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDetail(@PathVariable Integer afpId, @PathVariable Integer id,
                             @RequestBody @Valid AfpCommissionUpdateRequest updateRequest) {

        commissionService.update(AfpCommissionMapper.mapToBusiness(afpId, id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{afpId}/commissions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetail(@PathVariable Integer afpId, @PathVariable Integer id) {

        commissionService.deleteById(afpId, id);

    }


}
