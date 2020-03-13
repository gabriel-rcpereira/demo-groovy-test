package com.grcp.poc.groovy.app.gateway.jdbc.mapper;

import com.grcp.poc.groovy.app.core.domain.*;
import com.grcp.poc.groovy.app.gateway.jdbc.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    UserEntity mapper(User user);
    User mapper(UserEntity entity);
    List<User> mapper(List<UserEntity> users);
}
