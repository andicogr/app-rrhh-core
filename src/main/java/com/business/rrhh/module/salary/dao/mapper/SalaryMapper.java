package com.business.rrhh.module.salary.dao.mapper;

import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.module.salary.model.database.SalaryEntity;
import com.business.rrhh.module.salary.state.SalaryStates;
import com.business.rrhh.util.dao.mapper.CompanyMapper;

import static java.util.Objects.nonNull;

public class SalaryMapper {

    public static SalaryEntity mapToEntity(Salary salary) {

        EmployeeEntity employeeEntity = nonNull(salary.getEmployee()) ? EmployeeMapper.mapToEntity(salary.getEmployee()) : null;

        String stateCode = nonNull(salary.getState()) ? salary.getState().getCode() : null;

        return SalaryEntity.builder()
                .id(salary.getId())
                .employee(employeeEntity)
                .amount(salary.getAmount())
                .netAmount(salary.getNetAmount())
                .familyAllowance(salary.getFamilyAllowance())
                .startDate(salary.getStartDate())
                .endDate(salary.getEndDate())
                .state(stateCode)
                .company(CompanyMapper.mapToEntity(salary.getCompany()))
                .build();

    }

    public static Salary mapToSalary(SalaryEntity entity) {

        return Salary.builder()
                .id(entity.getId())
                .employee(EmployeeMapper.mapToEmployee(entity.getEmployee()))
                .amount(entity.getAmount())
                .netAmount(entity.getNetAmount())
                .familyAllowance(entity.getFamilyAllowance())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .state(SalaryStates.getByCode(entity.getState()).buildState())
                .company(CompanyMapper.mapToCompany(entity.getCompany()))
                .build();

    }
}
