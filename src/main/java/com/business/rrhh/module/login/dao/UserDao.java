package com.business.rrhh.module.login.dao;

import com.business.rrhh.module.login.dao.mapper.UserMapper;
import com.business.rrhh.module.login.dao.repository.UserRepository;
import com.business.rrhh.module.login.error.LoginException;
import com.business.rrhh.module.login.model.business.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Repository
@AllArgsConstructor
public class UserDao {

    private UserRepository repository;

    public Page<User> getByPage(User user, Pageable pageable) {

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("username", contains().ignoreCase());

        return repository.findAll(Example.of(UserMapper.mapToEntity(user), matcher), pageable)
                .map(UserMapper::mapToBusiness);

    }

    public List<User> getAll(User user) {

        return repository.findAll(Example.of(UserMapper.mapToEntity(user)))
                .stream()
                .map(UserMapper::mapToBusiness)
                .collect(Collectors.toList());

    }

    public User getById(Integer id) {

        return repository.findById(id)
                .map(UserMapper::mapToBusiness)
                .orElseThrow(() -> LoginException.USER_NOT_FOUND.build());

    }

    public User save(User user) {

        return UserMapper.mapToBusiness(repository.save(UserMapper.mapToEntity(user)));

    }

    public void deleteById(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

        }

    }

}
