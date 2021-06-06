package com.business.rrhh.module.company.dao;

import com.business.rrhh.module.company.dao.mapper.CompanyMapper;
import com.business.rrhh.module.company.dao.repository.CompanyRepository;
import com.business.rrhh.module.company.error.CompanyException;
import com.business.rrhh.module.company.model.business.Company;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Repository
@AllArgsConstructor
public class CompanyDao {

    private CompanyRepository repository;

    public Page<Company> getAll(Company company, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("brandName", contains().ignoreCase())
                .withMatcher("ruc", contains().ignoreCase());

        return repository.findAll(Example.of(CompanyMapper.mapToEntity(company), matcher), pageable)
                .map(CompanyMapper::mapToBusiness);

    }

    public Company getById(Integer id) {

        return repository.findById(id)
                .map(CompanyMapper::mapToBusiness)
                .orElseThrow(() -> CompanyException.COMPANY_NOT_FOUND.build());

    }

    public Company save(Company company) {

        return CompanyMapper.mapToBusiness(repository.save(CompanyMapper.mapToEntity(company)));

    }

    public Company update(Company updatedCompany) {

        return CompanyMapper.mapToBusiness(repository.save(CompanyMapper.mapToEntity(updatedCompany)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }
}
