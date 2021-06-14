package com.business.rrhh.module.salary.dao;

import com.business.rrhh.module.salary.dao.mapper.SalaryMapper;
import com.business.rrhh.module.salary.dao.repository.SalaryRepository;
import com.business.rrhh.module.salary.error.SalaryException;
import com.business.rrhh.module.salary.model.business.Salary;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SalaryDao {

    private SalaryRepository repository;

    public Page<Salary> getByPage(Salary salary, Pageable pageable) {


        return repository.findAll(Example.of(SalaryMapper.mapToEntity(salary)), pageable)
                .map(SalaryMapper::mapToSalary);

    }

    public List<Salary> getAll(Salary salary) {

        return repository.findAll(Example.of(SalaryMapper.mapToEntity(salary)))
                .stream()
                .map(SalaryMapper::mapToSalary)
                .collect(Collectors.toList());

    }

    public Salary getById(Integer id) {

        return repository.findById(id)
                .map(SalaryMapper::mapToSalary)
                .orElseThrow(() -> SalaryException.NOT_FOUND.build());

    }

    public Salary save(Salary salary) {

        return SalaryMapper.mapToSalary(repository.save(SalaryMapper.mapToEntity(salary)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

}
