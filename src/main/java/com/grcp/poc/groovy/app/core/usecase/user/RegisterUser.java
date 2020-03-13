package com.grcp.poc.groovy.app.core.usecase.user;

import com.grcp.poc.groovy.app.core.domain.User;
import com.grcp.poc.groovy.app.gateway.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;

@RequiredArgsConstructor
@Component
public class RegisterUser {

    private final UserGateway gateway;

    public User execute(User user) {
        var passwordDecoded = user.getPassword();
        user.setPassword(encode(passwordDecoded));
        return gateway.register(user);
    }

    private String encode(String value) {
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}
