package com.business.rrhh.module.afp.dao.repository;

import com.business.rrhh.module.afp.model.database.AfpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AfpRepository extends JpaRepository<AfpEntity, Integer> {

    Optional<AfpEntity> findByName(String name);

}
