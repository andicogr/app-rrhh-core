package com.business.rrhh.module.workschedule.dao;

import com.business.rrhh.module.workschedule.dao.mapper.WorkScheduleMapper;
import com.business.rrhh.module.workschedule.dao.repository.WorkScheduleRepository;
import com.business.rrhh.module.workschedule.error.WorkScheduleException;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.module.workschedule.model.database.WorkScheduleEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class WorkScheduleDao {

    private WorkScheduleRepository repository;

    public Page<WorkSchedule> getByPage(WorkSchedule workSchedule, Pageable pageable) {


        return repository.findAll(Example.of(WorkScheduleMapper.mapToEntity(workSchedule)), pageable)
                .map(WorkScheduleMapper::mapToBusiness);

    }

    public List<WorkSchedule> getAll(WorkSchedule workSchedule) {

        return repository.findAll(Example.of(WorkScheduleMapper.mapToEntity(workSchedule)))
                .stream()
                .map(WorkScheduleMapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public WorkSchedule getById(Integer id) {

        return repository.findById(id)
                .map(WorkScheduleMapper::mapToBusiness)
                .orElseThrow(() -> WorkScheduleException.NOT_FOUND.build());

    }

    public WorkSchedule save(WorkSchedule workSchedule) {

        return WorkScheduleMapper.mapToBusiness(repository.save(WorkScheduleMapper.mapToEntity(workSchedule)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

    public Optional<WorkSchedule> findByName(WorkSchedule workSchedule) {

        WorkScheduleEntity entity = WorkScheduleMapper.mapToEntity(workSchedule);

        return repository.findByName(entity.getName(), entity.getCompany().getId())
                .map(WorkScheduleMapper::mapToBusiness);

    }

}
