package com.business.rrhh.module.afp.dao.repository;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.afp.model.database.AfpCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;
import java.util.Optional;

public interface AfpCommissionRepository extends JpaRepository<AfpCommissionEntity, Integer> {

    Optional<AfpCommissionEntity> findByFiscalYearIdAndMonthAndAfpIdAndType(Integer fiscalYearId, Month month, Integer afpId, AfpType type);

    Optional<AfpCommissionEntity> findByAfpIdAndId(Integer afpId, Integer id);

    boolean existsByAfpIdAndId(Integer afpId, Integer id);
}
