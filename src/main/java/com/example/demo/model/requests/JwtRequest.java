package com.example.demo.model.requests;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private String email;
    private String password;

    public JwtRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
