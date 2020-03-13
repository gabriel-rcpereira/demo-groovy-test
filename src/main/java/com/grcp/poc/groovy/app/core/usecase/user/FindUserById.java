package com.grcp.poc.groovy.app.core.usecase.user;

import com.grcp.poc.groovy.app.core.domain.*;
import com.grcp.poc.groovy.app.gateway.UserGateway;
import com.grcp.poc.groovy.app.core.usecase.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserById {

    private final UserGateway gateway;

    public User execute(long id) throws EntityNotFoundException {
        return gateway.findById(id);
    }
}
