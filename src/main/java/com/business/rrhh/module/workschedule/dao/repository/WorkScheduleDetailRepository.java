package com.business.rrhh.module.workschedule.dao.repository;

import com.business.rrhh.module.workschedule.model.database.WorkScheduleDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.Optional;

@Repository
public interface WorkScheduleDetailRepository extends JpaRepository<WorkScheduleDetailEntity, Integer> {

    @Query("SELECT e FROM WorkScheduleDetailEntity e " +
            "WHERE e.dayOfWeek = :dayOfWeek " +
            "AND e.workSchedule.id = :workScheduleId")
    Optional<WorkScheduleDetailEntity> findByDayOfWeek(DayOfWeek dayOfWeek, Integer workScheduleId);

    Optional<WorkScheduleDetailEntity> findByWorkScheduleIdAndId(Integer parentId, Integer id);

    boolean existsByWorkScheduleIdAndId(Integer parentId, Integer id);

}
