package com.business.rrhh.module.employee.controller.mapper;

import com.business.rrhh.module.employee.model.api.*;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.util.controller.mapper.CompanyMapper;
import com.business.rrhh.util.controller.mapper.StateMapper;

public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeByPageSearchRequest searchRequest) {

        return Employee.builder()
                .firstName(searchRequest.getFirstName())
                .secondName(searchRequest.getSecondName())
                .paternalName(searchRequest.getPaternalName())
                .maternalName(searchRequest.getMaternalName())
                .documentType(Table3.builder().code(searchRequest.getDocumentType()).build())
                .documentNumber(searchRequest.getDocumentNumber())
                .state(StateMapper.mapToState(searchRequest.getState()))
                .company(CompanyMapper.mapToCompany(searchRequest.getCompanyId()))
                .build();

    }

    public static EmployeeSearchResponse mapToResponseSearch(Employee employee) {

        return EmployeeSearchResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .secondName(employee.getSecondName())
                .paternalName(employee.getPaternalName())
                .maternalName(employee.getMaternalName())
                .state(StateMapper.mapToResponse(employee.getState()))
                .documentType(Table3Mapper.mapToResponse(employee.getDocumentType()))
                .documentNumber(employee.getDocumentNumber())
                .company(CompanyMapper.mapToResponse(employee.getCompany()))
                .build();

    }

    public static Employee mapToEmployee(EmployeeCreateRequest createRequest) {

        return Employee.builder()
                .firstName(createRequest.getFirstName())
                .secondName(createRequest.getSecondName())
                .paternalName(createRequest.getPaternalName())
                .maternalName(createRequest.getMaternalName())
                .documentNumber(createRequest.getDocumentNumber())
                .documentType(Table3Mapper.mapToTable3(createRequest.getDocumentType()))
                .email(createRequest.getEmail())
                .workPhone(createRequest.getWorkPhone())
                .mobilePhone(createRequest.getMobilePhone())
                .bornDate(createRequest.getBornDate())
                .company(CompanyMapper.mapToCompany(createRequest.getCompany()))
                .build();

    }

    public static EmployeeResponse mapToIdResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .build();

    }

    public static Employee mapToEmployee(Integer id, EmployeeUpdateRequest updateRequest) {

        return Employee.builder()
                .id(id)
                .firstName(updateRequest.getFirstName())
                .secondName(updateRequest.getSecondName())
                .paternalName(updateRequest.getPaternalName())
                .maternalName(updateRequest.getMaternalName())
                .documentNumber(updateRequest.getDocumentNumber())
                .documentType(Table3Mapper.mapToTable3(updateRequest.getDocumentType()))
                .email(updateRequest.getEmail())
                .workPhone(updateRequest.getWorkPhone())
                .mobilePhone(updateRequest.getMobilePhone())
                .bornDate(updateRequest.getBornDate())
                .company(CompanyMapper.mapToCompany(updateRequest.getCompany()))
                .build();

    }

    public static EmployeeResponse mapToResponse(Employee employee) {

        return EmployeeResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .secondName(employee.getSecondName())
                .paternalName(employee.getPaternalName())
                .maternalName(employee.getMaternalName())
                .state(StateMapper.mapToResponse(employee.getState()))
                .documentType(Table3Mapper.mapToResponse(employee.getDocumentType()))
                .documentNumber(employee.getDocumentNumber())
                .email(employee.getEmail())
                .workPhone(employee.getWorkPhone())
                .mobilePhone(employee.getMobilePhone())
                .bornDate(employee.getBornDate())
                .company(CompanyMapper.mapToResponse(employee.getCompany()))
                .build();

    }
}
