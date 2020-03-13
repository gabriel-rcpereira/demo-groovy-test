package com.grcp.poc.groovy.app.gateway.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "sas_user")
public class UserEntity {

    @Id
    private long id;
    private String name;
    private String password;
}
