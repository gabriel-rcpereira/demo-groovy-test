package com.grcp.poc.groovy.app.gateway.jdbc;

import com.grcp.poc.groovy.app.core.domain.*;
import com.grcp.poc.groovy.app.gateway.UserGateway;
import com.grcp.poc.groovy.app.gateway.jdbc.entity.UserEntity;
import com.grcp.poc.groovy.app.gateway.jdbc.mapper.UserEntityMapper;
import com.grcp.poc.groovy.app.gateway.jdbc.repository.UserRepository;
import com.grcp.poc.groovy.app.core.usecase.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserGatewayImpl implements UserGateway {

    private final UserRepository repository;

    @Override
    public User register(User user) {
        UserEntity userEntity = UserEntityMapper.INSTANCE.mapper(user);
        return UserEntityMapper.INSTANCE.mapper(repository.save(userEntity));
    }

    @Override
    public User findById(long id) throws EntityNotFoundException {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, String.format("User not found with id: %s", id)));
        return UserEntityMapper.INSTANCE.mapper(userEntity);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> usersEntity = repository.findAll();
        return UserEntityMapper.INSTANCE.mapper(usersEntity);
    }
}
