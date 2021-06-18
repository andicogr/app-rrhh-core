package com.business.rrhh.module.employee.service;

import com.business.rrhh.module.employee.dao.SystemHealthDao;
import com.business.rrhh.module.employee.error.SystemHealthException;
import com.business.rrhh.module.employee.model.business.SystemHealth;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class SystemHealthService {

    private final SystemHealthDao dao;

    public SystemHealth getByEmployeeId(Integer employeeId) {

        return dao.getByEmployeeId(employeeId);

    }

    public void save(SystemHealth systemHealth) {

        if (dao.existsByEmployeeId(systemHealth.getEmployee().getId())) {
            throw SystemHealthException.ALREADY_EXISTS.build();
        }

        dao.save(systemHealth);

    }

    public void update(SystemHealth systemHealth) {

        SystemHealth foundedSystemHealth = dao.getByEmployeeId(systemHealth.getEmployee().getId());

        foundedSystemHealth.setType(requireNonNullElse(systemHealth.getType(), foundedSystemHealth.getType()));
        foundedSystemHealth.setStartDate(requireNonNullElse(systemHealth.getStartDate(), foundedSystemHealth.getStartDate()));

        dao.save(foundedSystemHealth);

    }

}
