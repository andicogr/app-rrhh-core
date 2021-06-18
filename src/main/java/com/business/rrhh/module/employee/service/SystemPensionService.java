package com.business.rrhh.module.employee.service;

import com.business.rrhh.module.employee.SystemPensionType;
import com.business.rrhh.module.employee.dao.SystemPensionDao;
import com.business.rrhh.module.employee.error.SystemPensionException;
import com.business.rrhh.module.employee.model.business.SystemPension;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class SystemPensionService {

    private final SystemPensionDao dao;

    public SystemPension getByEmployeeId(Integer employeeId) {

        return dao.getByEmployeeId(employeeId);

    }

    public void save(SystemPension systemPension) {

        if (dao.existsByEmployeeId(systemPension.getEmployee().getId())) {
            throw SystemPensionException.ALREADY_EXISTS.build();
        }

        dao.save(systemPension);

    }

    public void update(SystemPension systemPension) {

        SystemPension foundedSystemPension = dao.getByEmployeeId(systemPension.getEmployee().getId());

        foundedSystemPension.setType(requireNonNullElse(systemPension.getType(), foundedSystemPension.getType()));
        foundedSystemPension.setAfp(requireNonNullElse(systemPension.getAfp(), foundedSystemPension.getAfp()));
        foundedSystemPension.setStartDate(requireNonNullElse(systemPension.getStartDate(), foundedSystemPension.getStartDate()));
        foundedSystemPension.setAfpType(requireNonNullElse(systemPension.getAfpType(), foundedSystemPension.getAfpType()));
        foundedSystemPension.setCusppCode(requireNonNullElse(systemPension.getCusppCode(), foundedSystemPension.getCusppCode()));

        if (foundedSystemPension.getType().equals(SystemPensionType.ONP)) {
            foundedSystemPension.setAfpType(null);
            foundedSystemPension.setAfp(null);
            foundedSystemPension.setCusppCode(null);
        }

        dao.save(foundedSystemPension);

    }

}
