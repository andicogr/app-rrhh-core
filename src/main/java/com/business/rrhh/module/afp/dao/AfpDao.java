package com.business.rrhh.module.afp.dao;

import com.business.rrhh.module.afp.dao.mapper.AfpMapper;
import com.business.rrhh.module.afp.dao.repository.AfpRepository;
import com.business.rrhh.module.afp.error.AfpException;
import com.business.rrhh.module.afp.model.business.Afp;
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
public class AfpDao {

    private AfpRepository repository;

    public Page<Afp> getByPage(Afp afp, Pageable pageable) {


        return repository.findAll(Example.of(AfpMapper.mapToEntity(afp)), pageable)
                .map(AfpMapper::mapToBusiness);

    }

    public List<Afp> getAll(Afp afp) {

        return repository.findAll(Example.of(AfpMapper.mapToEntity(afp)))
                .stream()
                .map(AfpMapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public Afp getById(Integer id) {

        return repository.findById(id)
                .map(AfpMapper::mapToBusiness)
                .orElseThrow(() -> AfpException.NOT_FOUND.build());

    }

    public Afp save(Afp afp) {

        return AfpMapper.mapToBusiness(repository.save(AfpMapper.mapToEntity(afp)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

    public Optional<Afp> findByName(Afp afp) {

        return repository.findByName(afp.getName())
                .map(AfpMapper::mapToBusiness);

    }

}
