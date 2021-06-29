package com.business.rrhh.module.employee.dao.repository;

import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.util.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query("SELECT e FROM EmployeeEntity e " +
            "WHERE e.documentType = :docType " +
            "AND e.documentNumber = :docNumber " +
            "AND e.company.id = :companyId")
    Optional<EmployeeEntity> findByDocumentTypeAndNumber(DocType docType, String docNumber, Integer companyId);

}
