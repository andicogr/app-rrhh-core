package com.business.rrhh.module.workschedule.dao.repository;

import com.business.rrhh.module.workschedule.model.database.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkScheduleEntity, Integer> {

    @Query("SELECT e FROM WorkScheduleEntity e " +
            "WHERE e.name = :name " +
            "AND e.company.id = :companyId")
    Optional<WorkScheduleEntity> findByName(String name, Integer companyId);

}
