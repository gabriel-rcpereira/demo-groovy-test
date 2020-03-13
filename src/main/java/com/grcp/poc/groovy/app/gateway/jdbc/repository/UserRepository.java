package com.grcp.poc.groovy.app.gateway.jdbc.repository;

import com.grcp.poc.groovy.app.gateway.jdbc.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAll();
}
