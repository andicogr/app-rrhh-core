package com.business.rrhh.module.company.service;

import com.business.rrhh.module.company.dao.CompanyDao;
import com.business.rrhh.module.company.error.CompanyException;
import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.module.company.state.CompanyStates;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyDao companyDao;

    public Page<Company> getByPage(Company company, Pageable pageable) {

        return companyDao.getByPage(company, pageable);

    }

    public List<Company> getAll(Company company) {

        return companyDao.getAll(company);

    }

    public Company getById(Integer id) {

        return companyDao.getById(id);

    }

    public Company save(Company company) {

        company = company.mutate()
                .state(CompanyStates.ACTIVE.buildState())
                .build();

        return companyDao.save(company);

    }

    public Company updateById(Company company) {

        Company currentCompany = companyDao.getById(company.getId());

        Company updatedCompany = currentCompany.mutate()
                .phone(company.getPhone())
                .brandName(company.getBrandName())
                .address(company.getAddress())
                .email(company.getEmail())
                .ruc(company.getRuc())
                .build();

        return companyDao.update(updatedCompany);

    }

    public void deleteById(Integer id) {

        Company company = companyDao.getById(id);

        if (company.isActive()) {
            throw CompanyException.CANT_DELETE_ACTIVE_STATE.build();
        }

        companyDao.deleteById(id);

    }

    public boolean validateUniqueBrandName(Integer excludeId, String brandName) {

        return companyDao.isUniqueBrandName(excludeId, brandName);

    }

    public boolean validateUniqueRuc(Integer excludeId, String ruc) {

        return companyDao.isUniqueRuc(excludeId, ruc);

    }
}
