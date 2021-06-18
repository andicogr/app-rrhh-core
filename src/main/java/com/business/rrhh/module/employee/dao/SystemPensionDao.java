package com.business.rrhh.module.employee.dao;

import com.business.rrhh.module.employee.dao.mapper.SystemPensionMapper;
import com.business.rrhh.module.employee.dao.repository.SystemPensionRepository;
import com.business.rrhh.module.employee.error.SystemPensionException;
import com.business.rrhh.module.employee.model.business.SystemPension;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SystemPensionDao {

    private final SystemPensionRepository repository;

    public SystemPension getByEmployeeId(Integer employeeId) {

        return repository.findByEmployeeId(employeeId)
                .map(SystemPensionMapper::mapToBusiness)
                .orElseThrow(() -> SystemPensionException.NOT_FOUND.build());

    }

    public void save(SystemPension systemPension) {

        repository.save(SystemPensionMapper.mapToEntity(systemPension));

    }

    public boolean existsByEmployeeId(Integer employeeId) {

        return repository.existsByEmployeeId(employeeId);

    }

}
