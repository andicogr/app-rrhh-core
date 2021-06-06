package com.business.rrhh.module.login.controller;

import com.business.rrhh.module.login.controller.mapper.UserMapper;
import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.service.UserService;
import com.business.rrhh.util.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping
    @ResponseBody
    public PageResponse<UserSearchResponse> getAll(@Valid UserSearchRequest userSearchRequest) {

        return PageResponse.of(
                userService.getUsers(UserMapper.mapToUser(userSearchRequest), userSearchRequest.buildPageable())
                        .map(UserMapper::mapToResponseSearch)
        );

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public UserResponse getById(@PathVariable Integer id) {

        return UserMapper.mapToResponse(userService.getById(id));

    }

    @PostMapping
    @ResponseBody
    public UserResponse create(@RequestBody UserRequest userRequest){

        return UserMapper.mapToResponse(userService.save(UserMapper.mapToUser(userRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    public UserResponse update(@PathVariable Integer id, @RequestBody UserUpdateRequest userUpdateRequest) {

        return UserMapper.mapToResponse(userService.updateById(UserMapper.mapToUser(id, userUpdateRequest)));

    }

}
