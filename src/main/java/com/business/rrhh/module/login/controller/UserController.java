package com.business.rrhh.module.login.controller;

import com.business.rrhh.module.login.controller.mapper.UserMapper;
import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.module.login.service.UserService;
import com.business.rrhh.util.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @ResponseBody
    @GetMapping(params = {"page"})
    public PageResponse<UserSearchResponse> getByPage(@Valid UserByPageSearchRequest userSearchRequest) {

        return PageResponse.of(
                userService.getByPage(UserMapper.mapToUser(userSearchRequest), userSearchRequest.buildPageable())
                        .map(UserMapper::mapToResponseSearch)
        );

    }

    @GetMapping
    @ResponseBody
    public List<UserSearchResponse> getAll(String status) {

        User user = User.builder().status(status).build();

        return userService.getAll(user).stream()
                .map(UserMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public UserResponse getById(@PathVariable Integer id) {

        return UserMapper.mapToResponse(userService.getById(id));

    }

    @PostMapping
    @ResponseBody
    public UserResponse create(@RequestBody @Valid UserRequest userRequest){

        return UserMapper.mapToResponse(userService.save(UserMapper.mapToUser(userRequest)));

    }

    @ResponseBody
    @PatchMapping(value = "/{id}")
    public UserResponse update(@PathVariable Integer id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {

        return UserMapper.mapToResponse(userService.updateById(UserMapper.mapToUser(id, userUpdateRequest)));

    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        userService.deleteById(id);

    }

}
