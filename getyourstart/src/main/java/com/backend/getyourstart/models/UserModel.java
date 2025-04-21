package com.backend.getyourstart.models;

import java.io.Serializable;
import java.util.List;

import com.backend.getyourstart.dto.UserResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L; // ✅ Recommended for versioning

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy="user")
    private List<AdzunaJobModel> AdzunaJobs;

    @OneToMany(mappedBy="user")
    private List<JSearchJobModel> JSearchJobs;

    public UserModel() {

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

    public List<AdzunaJobModel> getAdzunaJobs() {
        return this.AdzunaJobs;
    }

    public void setAdzunaJobs(List<AdzunaJobModel> AdzunaJobs) {
        this.AdzunaJobs = AdzunaJobs;
    }

    public List<JSearchJobModel> getJSearchJobs() {
        return this.JSearchJobs;
    }

    public void setJSearchJobs(List<JSearchJobModel> JSearchJobs) {
        this.JSearchJobs = JSearchJobs;
    }

    public UserResponse createResponse() {
        UserResponse userResponse = new UserResponse();

        userResponse.setUsername(this.username);
        userResponse.setPassword(this.password);
        userResponse.setId(this.id);

        return userResponse;
    }
}
