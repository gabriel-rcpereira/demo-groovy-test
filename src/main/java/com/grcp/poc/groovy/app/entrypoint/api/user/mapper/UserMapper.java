package com.grcp.poc.groovy.app.entrypoint.api.user.mapper;

import com.grcp.poc.groovy.app.core.domain.User;
import com.grcp.poc.groovy.app.entrypoint.api.user.model.UserRequest;
import com.grcp.poc.groovy.app.entrypoint.api.user.model.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse mapper(User user);
    @Mapping(target = "id", ignore = true)
    User mapper(UserRequest request);
    List<UserResponse> mapper(List<User> users);
}
