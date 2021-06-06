package com.business.rrhh.module.login.service;

import com.business.rrhh.module.login.dao.UserDao;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.util.UpdateObjects;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        currentUser.setPassword(UpdateObjects.requireNonNullElse(user.getPassword(), currentUser.getPassword()));
        currentUser.setStatus(UpdateObjects.requireNonNullElse(user.getStatus(), currentUser.getStatus()));
        currentUser.setCompanies(UpdateObjects.requireNonNullElse(user.getCompanies(), currentUser.getCompanies()));

        return userDao.save(currentUser);

    }

    public void deleteById(Integer id) {

        userDao.deleteById(id);

    }
}
