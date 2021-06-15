package com.business.rrhh.module.workschedule.service;

import com.business.rrhh.module.workschedule.dao.WorkScheduleDetailDao;
import com.business.rrhh.module.workschedule.error.WorkScheduleDetailException;
import com.business.rrhh.module.workschedule.model.business.WorkSchedule;
import com.business.rrhh.module.workschedule.model.business.WorkScheduleDetail;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class WorkScheduleDetailService {

    private final WorkScheduleDetailDao dao;

    public List<WorkScheduleDetail> getByParent(WorkSchedule workSchedule) {

        return dao.getByParent(workSchedule).stream()
                .sorted(Comparator.comparing(WorkScheduleDetail::getOrder))
                .collect(Collectors.toList());

    }

    public WorkScheduleDetail getById(Integer partnerId, Integer id) {

        return dao.getById(partnerId, id);

    }

    public void save(WorkScheduleDetail detail) {

        this.validate(detail);

        detail.calculateWorkTime();

        dao.save(detail);

    }

    public void update(WorkScheduleDetail detail) {

        this.validate(detail);

        WorkScheduleDetail foundDetail = dao.getById(detail.getWorkSchedule().getId(), detail.getId());

        foundDetail.setDepartureTime(requireNonNullElse(detail.getDepartureTime(), foundDetail.getDepartureTime()));
        foundDetail.setDayOfWeek(requireNonNullElse(detail.getDayOfWeek(), foundDetail.getDayOfWeek()));
        foundDetail.setOpeningTime(requireNonNullElse(detail.getOpeningTime(), foundDetail.getOpeningTime()));
        foundDetail.calculateWorkTime();

        dao.save(foundDetail);

    }

    public void validate(WorkScheduleDetail detail) {

        dao.findByDayOfWeek(detail)
                .ifPresent(foundDetail -> {

                    if (Objects.isNull(detail.getId())) {

                        throw WorkScheduleDetailException.DAY_OF_WEEK_ALREADY_EXISTS.build();

                    } else if (Objects.nonNull(detail.getId())
                            && foundDetail.getId().intValue() != detail.getId().intValue()) {

                        throw WorkScheduleDetailException.DAY_OF_WEEK_ALREADY_EXISTS.build();

                    }

                });

    }

    public void deleteById(Integer parentId, Integer id) {

        dao.deleteById(parentId, id);

    }
}
