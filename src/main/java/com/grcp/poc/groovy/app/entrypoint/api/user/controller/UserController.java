package com.grcp.poc.groovy.app.entrypoint.api.user.controller;

import com.grcp.poc.groovy.app.core.domain.User;
import com.grcp.poc.groovy.app.core.usecase.exception.EntityNotFoundException;
import com.grcp.poc.groovy.app.core.usecase.user.FindUserById;
import com.grcp.poc.groovy.app.core.usecase.user.FindUsers;
import com.grcp.poc.groovy.app.core.usecase.user.RegisterUser;
import com.grcp.poc.groovy.app.entrypoint.api.user.mapper.UserMapper;
import com.grcp.poc.groovy.app.entrypoint.api.user.model.UserRequest;
import com.grcp.poc.groovy.app.entrypoint.api.user.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final RegisterUser registerUser;
    private final FindUserById findUserById;
    private final FindUsers findUsers;

    @PostMapping("/v1/users")
    public ResponseEntity<UserResponse> postUser(@RequestBody UserRequest request) {
        User newUser = UserMapper.INSTANCE.mapper(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.INSTANCE.mapper(registerUser.execute(newUser)));
    }

    @GetMapping("/v1/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") long id) throws EntityNotFoundException {
        User user = findUserById.execute(id);
        return ResponseEntity.ok(UserMapper.INSTANCE.mapper(user));
    }

    @GetMapping("/v1/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<User> users = findUsers.execute();
        return ResponseEntity.ok(UserMapper.INSTANCE.mapper(users));
    }
}
