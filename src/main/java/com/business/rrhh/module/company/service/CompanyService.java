package com.business.rrhh.module.company.service;

import com.business.rrhh.module.company.dao.CompanyDao;
import com.business.rrhh.module.login.model.business.Company;
import com.business.rrhh.util.api.PageSearch;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.stream.DoubleStream;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyDao companyDao;

    public Page<Company> getAll(Company company, PageSearch page) {

        return companyDao.getAll(company, page);

    }
}
