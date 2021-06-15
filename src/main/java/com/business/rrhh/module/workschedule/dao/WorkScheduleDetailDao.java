package com.business.rrhh.module.workschedule.dao;

import com.business.rrhh.module.workschedule.dao.mapper.WorkScheduleDetailMapper;
import com.business.rrhh.module.workschedule.dao.mapper.WorkScheduleMapper;
import com.business.rrhh.module.workschedule.dao.repository.WorkScheduleDetailRepository;
import com.business.rrhh.module.workschedule.error.WorkScheduleDetailException;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.module.workschedule.model.business.WorkScheduleDetail;
import com.business.rrhh.module.workschedule.model.database.WorkScheduleDetailEntity;
import com.business.rrhh.module.workschedule.model.database.WorkScheduleEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class WorkScheduleDetailDao {

    private WorkScheduleDetailRepository repository;

    public WorkScheduleDetail getById(Integer parentId, Integer id) {

        return repository.findByWorkScheduleIdAndId(parentId, id)
                .map(WorkScheduleDetailMapper::mapToBusiness)
                .orElseThrow(() -> WorkScheduleDetailException.NOT_FOUND.build());

    }

    public List<WorkScheduleDetail> getByParent(WorkSchedule workSchedule) {

        WorkScheduleEntity workScheduleEntity = WorkScheduleMapper.mapToEntity(workSchedule);

        WorkScheduleDetailEntity workScheduleDetailEntity = WorkScheduleDetailEntity.builder()
                .workSchedule(workScheduleEntity)
                .build();

        return repository.findAll(Example.of(workScheduleDetailEntity)).stream()
                .map(WorkScheduleDetailMapper::mapToBusiness)
                .collect(Collectors.toUnmodifiableList());
    }

    public Optional<WorkScheduleDetail> findByDayOfWeek(WorkScheduleDetail detail) {

        return repository.findByDayOfWeek(detail.getDayOfWeek(), detail.getWorkSchedule().getId())
                .map(WorkScheduleDetailMapper::mapToBusiness);

    }

    public void save(WorkScheduleDetail scheduleDetail) {

        repository.save(WorkScheduleDetailMapper.mapToEntity(scheduleDetail));

    }

    public void deleteById(Integer parentId, Integer id) {

        if (repository.existsByWorkScheduleIdAndId(parentId, id)) {

            repository.deleteById(id);

        }

    }

}
