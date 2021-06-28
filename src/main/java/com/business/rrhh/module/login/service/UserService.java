package com.business.rrhh.module.login.service;

import com.business.rrhh.module.login.dao.UserDao;
import com.business.rrhh.module.login.error.LoginException;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.util.UpdateObjects;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    public Page<User> getByPage(User userSearch, Pageable page) {

        return userDao.getByPage(userSearch, page);

    }

    public List<User> getAll(User user) {

        return userDao.getAll(user);

    }

    public User getById(Integer id) {

        return userDao.getById(id);
    }

    public User save(User user) {

        if (userDao.isUsernameAlreadyInUse(user.getUsername())) {
            String detail = "El nombre de usuario ya existe";
            throw LoginException.INVALID_USER_CREATION.build(detail);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userDao.save(user);

    }

    public User updateById(User user) {

        User currentUser = userDao.getById(user.getId());

        if (Objects.nonNull(user.getPassword())) {
            currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        currentUser.setUsername(UpdateObjects.requireNonNullElse(user.getUsername(), currentUser.getUsername()));
        currentUser.setState(UpdateObjects.requireNonNullElse(user.getState(), currentUser.getState()));
        currentUser.setCompanies(UpdateObjects.requireNonNullElse(user.getCompanies(), currentUser.getCompanies()));

        return userDao.save(currentUser);

    }

    public void deleteById(Integer id) {

        userDao.deleteById(id);

    }

    public User getByUsername(String username) {

        return userDao.getByUsername(username);

    }

}
