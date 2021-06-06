package com.business.rrhh.module.login.service;

import com.business.rrhh.module.login.dao.UserDao;
import com.business.rrhh.module.login.model.business.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    public Page<User> getUsers(User userSearch, Pageable page) {

        return userDao.getUsers(userSearch, page);

    }

    public User getById(Integer id) {

        return userDao.getById(id);
    }

    public User save(User user) {

        return userDao.save(user);

    }

    public User updateById(User user) {

        User currentUser = userDao.getById(user.getId());
        currentUser.setPassword(Objects.requireNonNullElse(user.getPassword(), currentUser.getPassword()));
        currentUser.setStatus(Objects.requireNonNullElse(user.getStatus(), currentUser.getStatus()));
        currentUser.setCompany(Objects.requireNonNullElse(user.getCompany(), currentUser.getCompany()));

        return userDao.save(currentUser);

    }
}
