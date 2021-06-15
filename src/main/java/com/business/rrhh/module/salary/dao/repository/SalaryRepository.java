package com.business.rrhh.module.salary.dao.repository;

import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.module.salary.model.database.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntity, Integer> {

    boolean existsByEmployeeIdAndState(Integer id, String code);

    @Query("SELECT e " +
            "FROM SalaryEntity e " +
            "WHERE e.employee.id = :employeeId " +
            "AND e.state not in :states " +
            "ORDER BY e.startDate")
    List<Salary> findValidSalariesByEmployeeId(Integer employeeId, List<String> states);

}
