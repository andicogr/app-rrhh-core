package com.business.rrhh.module.company.dao;

import com.business.rrhh.module.company.dao.mapper.CompanyMapper;
import com.business.rrhh.module.company.dao.repository.CompanyRepository;
import com.business.rrhh.module.login.model.business.Company;
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
}
