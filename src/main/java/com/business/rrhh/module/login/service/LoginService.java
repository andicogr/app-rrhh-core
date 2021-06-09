package com.business.rrhh.module.login.service;

import com.business.rrhh.module.login.dao.UserDao;
import com.business.rrhh.module.login.error.LoginException;
import com.business.rrhh.module.login.model.business.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LoginService {

    private UserDao userDao;

    public void login(User user) {

        User currentUser = userDao.getByUsernameAndPassword(user.getUsername(), user.getPassword())
                .orElseThrow(LoginException.BAD_CREDENTIALS::build);

        log.info("Login user {} with companies: ", currentUser.getUsername());
        currentUser.getCompanies()
                .forEach(company -> log.info("    {} - {}", company.getId(), company.getBrandName()));

    }

}
