package com.business.rrhh.module.employee.dao.repository;

import com.business.rrhh.module.employee.model.database.SystemHealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemHealthRepository extends JpaRepository<SystemHealthEntity, Integer> {

    Optional<SystemHealthEntity> findByEmployeeId(Integer employeeId);

    boolean existsByEmployeeId(Integer employeeId);
}
