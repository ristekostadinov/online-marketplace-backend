package com.example.demo.model.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    SUPER_ADMIN,
    MODERATOR;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
