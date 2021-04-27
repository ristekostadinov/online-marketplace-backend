package com.example.demo.model.response;

import com.example.demo.model.enumeration.Role;

public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
    private final Long id;
    private final String email;
    private final Role role;


    public JwtResponse(String jwtToken, Long id, String email, Role role) {
        this.jwtToken = jwtToken;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return this.jwtToken;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }
}
