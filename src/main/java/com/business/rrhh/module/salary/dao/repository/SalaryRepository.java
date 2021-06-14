package com.business.rrhh.module.salary.dao.repository;

import com.business.rrhh.module.salary.model.database.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {

}
