package com.business.rrhh.module.employee.dao.repository;

import com.business.rrhh.module.employee.model.database.SystemPensionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemPensionRepository extends JpaRepository<SystemPensionEntity, Integer> {

    Optional<SystemPensionEntity> findByEmployeeId(Integer employeeId);

    boolean existsByEmployeeId(Integer employeeId);
}
