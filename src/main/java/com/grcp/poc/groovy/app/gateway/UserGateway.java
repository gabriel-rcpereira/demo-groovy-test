package com.grcp.poc.groovy.app.gateway;

import com.grcp.poc.groovy.app.core.domain.User;
import com.grcp.poc.groovy.app.core.usecase.exception.EntityNotFoundException;

import java.util.List;

public interface UserGateway {

    User register(User userToRegister);

    User findById(long id) throws EntityNotFoundException;

    List<User> findAll();
}
