package com.business.rrhh.module.workschedule.service;

import com.business.rrhh.module.workschedule.dao.WorkScheduleDao;
import com.business.rrhh.module.workschedule.error.WorkScheduleException;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class WorkScheduleService {

    private final WorkScheduleDao dao;

    public Page<WorkSchedule> getByPage(WorkSchedule workSchedule, PageRequest pageRequest) {

        return dao.getByPage(workSchedule, pageRequest);

    }

    public List<WorkSchedule> getAll(WorkSchedule salary) {

        return dao.getAll(salary);

    }

    public WorkSchedule getById(Integer id) {

        return dao.getById(id);

    }

    public WorkSchedule save(WorkSchedule salary) {

        this.validate(salary);

        return dao.save(salary);

    }

    public void updateById(WorkSchedule workSchedule) {

        this.validate(workSchedule);

        WorkSchedule foundWorkSchedule = dao.getById(workSchedule.getId());

        foundWorkSchedule.setCompany(requireNonNullElse(workSchedule.getCompany(), foundWorkSchedule.getCompany()));
        foundWorkSchedule.setName(requireNonNullElse(workSchedule.getName(), foundWorkSchedule.getName()));
        foundWorkSchedule.setOpeningTolerance(requireNonNullElse(workSchedule.getOpeningTolerance(), foundWorkSchedule.getOpeningTolerance()));
        foundWorkSchedule.setDepartureTolerance(requireNonNullElse(workSchedule.getDepartureTolerance(), foundWorkSchedule.getDepartureTolerance()));
        foundWorkSchedule.setActive(requireNonNullElse(workSchedule.getActive(), foundWorkSchedule.getActive()));

        dao.save(foundWorkSchedule);

    }

    private void validate(WorkSchedule workSchedule) {

        dao.findByName(workSchedule)
                .ifPresent(foundWorkSchedule -> {

                    if (Objects.isNull(workSchedule.getId())) {

                        throw WorkScheduleException.NAME_ALREADY_EXISTS.build();

                    } else if (Objects.nonNull(workSchedule.getId())
                            && foundWorkSchedule.getId().intValue() != workSchedule.getId().intValue()) {

                        throw WorkScheduleException.NAME_ALREADY_EXISTS.build();

                    }

                });

    }

    public void deleteById(Integer id) {

        dao.deleteById(id);

    }

}
