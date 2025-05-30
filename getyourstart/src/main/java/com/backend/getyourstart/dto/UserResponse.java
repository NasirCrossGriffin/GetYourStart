package com.backend.getyourstart.dto;

import java.util.List;

import com.backend.getyourstart.models.AdzunaJobModel;
import com.backend.getyourstart.models.JSearchJobModel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class UserResponse {
    private Long id;
    private String username;
    private String password;


    public UserResponse() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
