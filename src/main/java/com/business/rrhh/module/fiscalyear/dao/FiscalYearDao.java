package com.business.rrhh.module.fiscalyear.dao;

import com.business.rrhh.module.fiscalyear.dao.mapper.FiscalYearMapper;
import com.business.rrhh.module.fiscalyear.dao.repository.FiscalYearRepository;
import com.business.rrhh.module.fiscalyear.error.FiscalYearException;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FiscalYearDao {

    private FiscalYearRepository repository;

    public Page<FiscalYear> getByPage(FiscalYear fiscalYear, Pageable pageable) {

        return repository.findAll(Example.of(FiscalYearMapper.mapToEntity(fiscalYear)), pageable)
                .map(FiscalYearMapper::mapToBusiness);

    }

    public List<FiscalYear> getAll(FiscalYear fiscalYear) {

        return repository.findAll(Example.of(FiscalYearMapper.mapToEntity(fiscalYear)))
                .stream()
                .map(FiscalYearMapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public FiscalYear getById(Integer id) {

        return repository.findById(id)
                .map(FiscalYearMapper::mapToBusiness)
                .orElseThrow(() -> FiscalYearException.NOT_FOUND.build());

    }

    public FiscalYear save(FiscalYear fiscalYear) {

        return FiscalYearMapper.mapToBusiness(repository.save(FiscalYearMapper.mapToEntity(fiscalYear)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

    public Optional<FiscalYear> findByName(FiscalYear fiscalYear) {

        return repository.findByYear(fiscalYear.getYear())
                .map(FiscalYearMapper::mapToBusiness);

    }

}
