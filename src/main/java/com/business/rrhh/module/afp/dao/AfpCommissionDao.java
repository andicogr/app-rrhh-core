package com.business.rrhh.module.afp.dao;

import com.business.rrhh.module.afp.dao.mapper.AfpCommissionMapper;
import com.business.rrhh.module.afp.dao.repository.AfpCommissionRepository;
import com.business.rrhh.module.afp.error.AfpCommissionException;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.business.AfpCommission;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AfpCommissionDao {

    private AfpCommissionRepository repository;

    public Page<AfpCommission> getPageByParent(Afp afp, Pageable pageable) {

        return repository.findAll(Example.of(AfpCommissionMapper.mapToEntity(afp)), pageable)
                .map(AfpCommissionMapper::mapToBusiness);

    }

    public AfpCommission getById(Integer parentId, Integer id) {

        return repository.findByAfpIdAndId(parentId, id)
                .map(AfpCommissionMapper::mapToBusiness)
                .orElseThrow(() -> AfpCommissionException.NOT_FOUND.build());

    }

    public void save(AfpCommission afpCommission) {

        repository.save(AfpCommissionMapper.mapToEntity(afpCommission));

    }

    public void deleteById(Integer parentId, Integer id) {

        if (repository.existsByAfpIdAndId(parentId, id)) {

            repository.deleteById(id);

        }

    }

    public Optional<AfpCommission> findToValidate(AfpCommission afpCommission) {

        return repository.findByFiscalYearIdAndMonthAndAfpIdAndType(
                afpCommission.getFiscalYear().getId(),
                afpCommission.getMonth().getCode(),
                afpCommission.getAfp().getId(),
                afpCommission.getType()
        )
                .map(AfpCommissionMapper::mapToBusiness);

    }

}
