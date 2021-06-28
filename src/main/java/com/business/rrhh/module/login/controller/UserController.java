package com.business.rrhh.module.login.controller;

import com.business.rrhh.module.login.controller.mapper.UserMapper;
import com.business.rrhh.module.login.model.api.*;
import com.business.rrhh.module.login.model.business.User;
import com.business.rrhh.module.login.service.UserService;
import com.business.rrhh.module.login.state.UserStates;
import com.business.rrhh.util.model.api.PageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @GetMapping(params = {"page"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<UserSearchResponse> getByPage(@Valid UserByPageSearchRequest userSearchRequest) {

        return PageResponse.of(
                userService.getByPage(UserMapper.mapToUser(userSearchRequest), userSearchRequest.buildPageable())
                        .map(UserMapper::mapToResponseSearch)
        );

    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserSearchResponse> getAll(String state) {

        User user = User.builder().state(UserStates.getByCode(state).buildState()).build();

        return userService.getAll(user).stream()
                .map(UserMapper::mapToResponseSearch)
                .collect(Collectors.toList());

    }

    @ResponseBody
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getById(@PathVariable Integer id) {

        return UserMapper.mapToResponse(userService.getById(id));

    }

    @ResponseBody
    @GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getByUsername(@PathVariable String username) {

        return UserMapper.mapToResponse(userService.getByUsername(username));

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse create(@RequestBody @Valid UserCreateRequest userRequest) {

        return UserMapper.mapToIdResponse(userService.save(UserMapper.mapToUser(userRequest)));

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable Integer id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) {

        userService.updateById(UserMapper.mapToUser(id, userUpdateRequest));

    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {

        userService.deleteById(id);

    }

}
