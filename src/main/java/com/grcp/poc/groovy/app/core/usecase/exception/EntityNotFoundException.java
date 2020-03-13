package com.grcp.poc.groovy.app.core.usecase.exception;

import lombok.Getter;

public class EntityNotFoundException extends Exception {

    @Getter
    private Class entity;

    public EntityNotFoundException(Class entity, String message) {
        super(message);
        this.entity = entity;
    }
}
