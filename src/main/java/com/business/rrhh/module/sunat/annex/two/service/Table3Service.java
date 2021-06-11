package com.business.rrhh.module.sunat.annex.two.service;

import com.business.rrhh.module.sunat.annex.two.dao.Table3Dao;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.util.model.business.Company;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Table3Service {

    private Table3Dao table3Dao;

    public Page<Table3> getByPage(Table3 table3, PageRequest pageRequest) {

        return table3Dao.getByPage(table3, pageRequest);
    }

    public void clone(Company company, List<Integer> ids) {

        List<Table3> newTable3List = table3Dao.getByIds(ids).stream()
                .map(table3 -> table3.clone(company))
                .collect(Collectors.toList());

        table3Dao.save(newTable3List);

    }

}
