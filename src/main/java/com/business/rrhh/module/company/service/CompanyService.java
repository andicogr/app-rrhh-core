package com.business.rrhh.module.company.service;

import com.business.rrhh.module.company.dao.CompanyDao;
import com.business.rrhh.module.login.model.business.Company;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyDao companyDao;

    public Page<Company> getAll(Company company, Pageable pageable) {

        return companyDao.getAll(company, pageable);

    }
}
