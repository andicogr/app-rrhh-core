package com.business.rrhh.module.workschedule.controller;

import com.business.rrhh.module.workschedule.controller.mapper.WorkScheduleDetailMapper;
import com.business.rrhh.module.workschedule.controller.mapper.WorkScheduleMapper;
import com.business.rrhh.module.workschedule.model.api.*;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.module.workschedule.service.WorkScheduleDetailService;
import com.business.rrhh.module.workschedule.service.WorkScheduleService;
import com.business.rrhh.util.model.api.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/work-schedules")
public class WorkScheduleController {

    private WorkScheduleService service;
    private WorkScheduleDetailService detailService;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<WorkScheduleSearchResponse> getByPage(@Valid WorkScheduleByPageSearchRequest searchRequest) {

        return PageResponse.of(
                service.getByPage(WorkScheduleMapper.mapToBusiness(searchRequest), searchRequest.buildPageable())
                        .map(WorkScheduleMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<WorkScheduleSearchResponse> getAll(Boolean active) {

        WorkSchedule workSchedule = WorkSchedule.builder().active(active).build();

        return service.getAll(workSchedule).stream()
                .map(WorkScheduleMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public WorkScheduleResponse getById(@PathVariable Integer id) {

        return WorkScheduleMapper.mapToResponse(service.getById(id));

    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public WorkScheduleResponse create(@RequestBody @Valid WorkScheduleCreateRequest createRequest) {

        return WorkScheduleMapper.mapToIdResponse(service.save(WorkScheduleMapper.mapToBusiness(createRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid WorkScheduleUpdateRequest updateRequest) {

        service.updateById(WorkScheduleMapper.mapToBusiness(id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        service.deleteById(id);

    }

    @ResponseBody
    @GetMapping(value = "/{id}/details")
    public List<WorkScheduleDetailResponse> getDetails(@PathVariable Integer id) {

        WorkSchedule schedule = WorkSchedule.builder().id(id).build();

        return detailService.getByParent(schedule).stream()
                .map(WorkScheduleDetailMapper::mapToResponse)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @PostMapping(value = "/{parentId}/details")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDetail(@PathVariable Integer parentId,
                             @RequestBody @Valid WorkScheduleDetailCreateRequest createRequest) {

        detailService.save(WorkScheduleDetailMapper.mapToBusiness(parentId, createRequest));

    }


    @ResponseBody
    @GetMapping(value = "/{parentId}/details/{id}")
    public WorkScheduleDetailResponse getDetail(@PathVariable Integer parentId, @PathVariable Integer id) {

        return WorkScheduleDetailMapper.mapToResponse(detailService.getById(parentId, id));

    }

    @ResponseBody
    @PatchMapping(value = "/{parentId}/details/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDetail(@PathVariable Integer parentId, @PathVariable Integer id,
                             @RequestBody @Valid WorkScheduleDetailUpdateRequest updateRequest) {

        detailService.update(WorkScheduleDetailMapper.mapToBusiness(parentId, id, updateRequest));

    }

    @ResponseBody
    @DeleteMapping(value = "/{parentId}/details/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDetail(@PathVariable Integer parentId, @PathVariable Integer id) {

        detailService.deleteById(parentId, id);

    }

}
