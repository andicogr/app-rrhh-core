package com.business.rrhh.module.login.dao;

import com.business.rrhh.module.login.dao.mapper.UserMapper;
import com.business.rrhh.module.login.error.LoginException;
import com.business.rrhh.util.api.PageSearch;
import com.business.rrhh.module.login.dao.repository.UserRepository;
import com.business.rrhh.module.login.model.business.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Repository
@AllArgsConstructor
public class UserDao {

    private UserRepository repository;

    public Page<User> getUsers(User user, PageSearch pageSearch) {

        ExampleMatcher matcher = ExampleMatcher
                .matchingAll()
                .withMatcher("username", contains().ignoreCase());

        return repository.findAll(Example.of(UserMapper.mapToEntity(user), matcher), pageSearch.buildPageable())
                .map(UserMapper::mapToBusiness);

    }

    public User getById(Integer id) {

        return repository.findById(id)
                .map(UserMapper::mapToBusiness)
                .orElseThrow(() -> LoginException.USER_NOT_FOUND.build());

    }

    public User save(User user) {

        return UserMapper.mapToBusiness(repository.save(UserMapper.mapToEntity(user)));

    }

}
