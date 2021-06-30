package com.business.rrhh.module.company.dao.repository;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

    boolean existsByIdNotAndRucIgnoreCase(Integer excludeId, String ruc);

    boolean existsByIdNotAndBrandNameIgnoreCase(Integer excludeId, String brandName);
}
