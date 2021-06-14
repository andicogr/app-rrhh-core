package com.business.rrhh.module.salary.controller.mapper;

import com.business.rrhh.module.salary.model.api.*;
import com.business.rrhh.module.salary.model.business.Salary;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.util.Money;
import com.business.rrhh.util.controller.mapper.CompanyMapper;
import com.business.rrhh.util.controller.mapper.StateMapper;

public class SalaryMapper {

    public static Salary mapToSalary(SalaryByPageSearchRequest searchRequest) {

        return Salary.builder()
                .employee(EmployeeMapper.mapToEmployee(searchRequest.getEmployeeId()))
                .state(StateMapper.mapToState(searchRequest.getState()))
                .company(CompanyMapper.mapToCompany(searchRequest.getCompanyId()))
                .build();

    }

    public static SalarySearchResponse mapToResponseSearch(Salary salary) {

        return SalarySearchResponse.builder()
                .id(salary.getId())
                .company(CompanyMapper.mapToResponse(salary.getCompany()))
                .employee(EmployeeMapper.mapToResponse(salary.getEmployee()))
                .amount(Money.format(salary.getAmount()).toString())
                .familyAllowance(salary.getFamilyAllowance())
                .startDate(salary.getStartDate())
                .endDate(salary.getEndDate())
                .state(StateMapper.mapToResponse(salary.getState()))
                .build();

    }

    public static Salary mapToSalary(SalaryCreateRequest createRequest) {

        return Salary.builder()
                .company(CompanyMapper.mapToCompany(createRequest.getCompany()))
                .employee(EmployeeMapper.mapToEmployee(createRequest.getEmployee()))
                .amount(createRequest.getAmount())
                .familyAllowance(createRequest.isFamilyAllowance())
                .startDate(createRequest.getStartDate())
                .endDate(createRequest.getEndDate())
                .build();

    }

    public static SalaryResponse mapToIdResponse(Salary salary) {

        return SalaryResponse.builder()
                .id(salary.getId())
                .build();

    }

    public static Salary mapToSalary(Integer id, SalaryUpdateRequest updateRequest) {

        return Salary.builder()
                .id(id)
                .company(CompanyMapper.mapToCompany(updateRequest.getCompany()))
                .employee(EmployeeMapper.mapToEmployee(updateRequest.getEmployee()))
                .amount(updateRequest.getAmount())
                .familyAllowance(updateRequest.getFamilyAllowance())
                .startDate(updateRequest.getStartDate())
                .endDate(updateRequest.getEndDate())
                .build();

    }

    public static SalaryResponse mapToResponse(Salary salary) {

        return SalaryResponse.builder()
                .id(salary.getId())
                .company(CompanyMapper.mapToResponse(salary.getCompany()))
                .employee(EmployeeMapper.mapToResponse(salary.getEmployee()))
                .amount(Money.format(salary.getAmount()).toString())
                .familyAllowance(salary.getFamilyAllowance())
                .startDate(salary.getStartDate())
                .endDate(salary.getEndDate())
                .state(StateMapper.mapToResponse(salary.getState()))
                .build();

    }
}
