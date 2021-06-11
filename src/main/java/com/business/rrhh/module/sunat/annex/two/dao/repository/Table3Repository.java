package com.business.rrhh.module.sunat.annex.two.dao.repository;

import com.business.rrhh.module.sunat.annex.two.model.database.Table3Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Table3Repository extends JpaRepository<Table3Entity, Integer> {
}
