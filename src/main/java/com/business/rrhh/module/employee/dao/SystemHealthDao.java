package com.business.rrhh.module.employee.dao;

import com.business.rrhh.module.employee.dao.mapper.SystemHealthMapper;
import com.business.rrhh.module.employee.dao.repository.SystemHealthRepository;
import com.business.rrhh.module.employee.error.SystemHealthException;
import com.business.rrhh.module.employee.model.business.SystemHealth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SystemHealthDao {

    private final SystemHealthRepository repository;

    public SystemHealth getByEmployeeId(Integer employeeId) {

        return repository.findByEmployeeId(employeeId)
                .map(SystemHealthMapper::mapToBusiness)
                .orElseThrow(() -> SystemHealthException.NOT_FOUND.build());

    }

    public void save(SystemHealth systemHealth) {

        repository.save(SystemHealthMapper.mapToEntity(systemHealth));

    }

    public boolean existsByEmployeeId(Integer employeeId) {

        return repository.existsByEmployeeId(employeeId);

    }

}
