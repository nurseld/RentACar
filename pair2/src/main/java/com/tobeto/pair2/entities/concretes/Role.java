package com.tobeto.pair2.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    CUSTOMER;


    @Override
    public String getAuthority() {
        return name();
    }
}
