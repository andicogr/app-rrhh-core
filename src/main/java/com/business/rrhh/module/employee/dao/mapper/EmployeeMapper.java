package com.business.rrhh.module.employee.dao.mapper;

import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.module.employee.state.EmployeeStates;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

import static java.util.Objects.nonNull;

public class EmployeeMapper {

    public static EmployeeEntity mapToEntity(Employee employee) {

        String stateCode = nonNull(employee.getState()) ? employee.getState().getCode() : null;

        return EmployeeEntity.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .secondName(employee.getSecondName())
                .paternalName(employee.getPaternalName())
                .maternalName(employee.getMaternalName())
                .fullName(employee.getFullName())
                .state(stateCode)
                .documentType(employee.getDocumentType())
                .documentNumber(employee.getDocumentNumber())
                .email(employee.getEmail())
                .workPhone(employee.getWorkPhone())
                .mobilePhone(employee.getMobilePhone())
                .bornDate(employee.getBornDate())
                .company(CompanyMapper.mapToEntity(employee.getCompany()))
                .build();

    }

    public static Employee mapToBusiness(EmployeeEntity entity) {

        return Employee.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .paternalName(entity.getPaternalName())
                .maternalName(entity.getMaternalName())
                .fullName(entity.getFullName())
                .state(EmployeeStates.getByCode(entity.getState()).buildState())
                .documentType(entity.getDocumentType())
                .documentNumber(entity.getDocumentNumber())
                .email(entity.getEmail())
                .workPhone(entity.getWorkPhone())
                .mobilePhone(entity.getMobilePhone())
                .bornDate(entity.getBornDate())
                .company(CompanyMapper.mapToCompany(entity.getCompany()))
                .build();

    }
}
