package com.business.rrhh.module.employee.dao;

import com.business.rrhh.module.employee.dao.mapper.EmployeeMapper;
import com.business.rrhh.module.employee.dao.repository.EmployeeRepository;
import com.business.rrhh.module.employee.error.EmployeeException;
import com.business.rrhh.module.employee.model.business.Employee;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Repository
@AllArgsConstructor
public class EmployeeDao {

    private EmployeeRepository repository;

    public Page<Employee> getByPage(Employee employee, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("firstName", contains().ignoreCase())
                .withMatcher("secondName", contains().ignoreCase())
                .withMatcher("paternalName", contains().ignoreCase())
                .withMatcher("maternalName", contains().ignoreCase())
                .withMatcher("documentNumber", contains().ignoreCase());

        return repository.findAll(Example.of(EmployeeMapper.mapToEntity(employee), matcher), pageable)
                .map(EmployeeMapper::mapToBusiness);

    }

    public List<Employee> getAll(Employee employee) {

        return repository.findAll(Example.of(EmployeeMapper.mapToEntity(employee)))
                .stream()
                .map(EmployeeMapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public Employee getById(Integer id) {

        return repository.findById(id)
                .map(EmployeeMapper::mapToBusiness)
                .orElseThrow(() -> EmployeeException.NOT_FOUND.build());

    }

    public Employee save(Employee employee) {

        return EmployeeMapper.mapToBusiness(repository.save(EmployeeMapper.mapToEntity(employee)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

    public Optional<Employee> findByDocumentTypeAndNumber(Employee employee) {

        EmployeeEntity entity = EmployeeMapper.mapToEntity(employee);

        return repository.findByDocumentTypeAndNumber(
                entity.getDocumentType().getId(),
                entity.getDocumentNumber(),
                entity.getCompany().getId()
        )
                .map(EmployeeMapper::mapToBusiness);

    }

}
