package com.backend.getyourstart.dto;

public class AuthenticationRequest {
    private String username;
    private String password;


    public AuthenticationRequest() {
        
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
