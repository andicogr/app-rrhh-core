package com.business.rrhh.module.login.controller;

import com.business.rrhh.module.login.controller.mapper.UserMapper;
import com.business.rrhh.module.login.model.api.LoginRequest;
import com.business.rrhh.module.login.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @PostMapping
    @ResponseBody
    public void login(@RequestBody LoginRequest loginRequest){

        loginService.login(UserMapper.mapToUser(loginRequest));

    }

}
