package com.business.rrhh.module.sunat.annex.two.dao;

import com.business.rrhh.module.sunat.annex.two.dao.mapper.Table3Mapper;
import com.business.rrhh.module.sunat.annex.two.dao.repository.Table3Repository;
import com.business.rrhh.module.sunat.annex.two.model.business.Table3;
import com.business.rrhh.module.sunat.annex.two.model.database.Table3Entity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Repository
@AllArgsConstructor
public class Table3Dao {

    private Table3Repository repository;

    public Page<Table3> getByPage(Table3 table3, PageRequest pageRequest) {

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("code", contains().ignoreCase())
                .withMatcher("description", contains().ignoreCase());

        return repository.findAll(Example.of(Table3Mapper.mapToEntity(table3), matcher), pageRequest)
                .map(Table3Mapper::mapToBusiness);

    }

    public List<Table3> getByIds(List<Integer> ids) {

        return repository.findAllById(ids).stream()
                .map(Table3Mapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public void save(List<Table3> table3List) {

        List<Table3Entity> entityList = table3List.stream()
                .map(Table3Mapper::mapToEntity)
                .collect(Collectors.toList());

        repository.saveAll(entityList);

    }

    public List<Table3> getAll(Table3 table3) {

        return repository.findAll(Example.of(Table3Mapper.mapToEntity(table3)))
                .stream()
                .map(Table3Mapper::mapToBusiness)
                .collect(Collectors.toList());

    }
}
