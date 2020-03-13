package com.grcp.poc.groovy.app.core.usecase.user;

import com.grcp.poc.groovy.app.core.domain.User;
import com.grcp.poc.groovy.app.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class FindUsers {

    private final UserGateway userGateway;

    public List<User> execute() {
        return userGateway.findAll();
    }
}
