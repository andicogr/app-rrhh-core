package com.business.rrhh.module.fiscalyear.dao.repository;

import com.business.rrhh.module.fiscalyear.model.database.FiscalYearEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FiscalYearRepository extends JpaRepository<FiscalYearEntity, Integer> {

    Optional<FiscalYearEntity> findByYear(Integer year);

}
