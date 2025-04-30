package com.backend.getyourstart.models;

import com.backend.getyourstart.dto.AdzunaJobHttpResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "adzuna_jobs")
public class AdzunaJobModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "redirect_url", nullable = true, length = 255)
    private String redirect_url;

    @Column(name = "created", nullable = true, length = 100)
    private String created;

    @Column(name = "salary_min", nullable = true, length = 100)
    private String salary_min;

    @Column(name = "salary_max", nullable = true, length = 100)
    private String salary_max;

    @Column(name = "contact_time", nullable = true, length = 100)
    private String contract_time;

    @Column(name = "salary_is_predicted", nullable = true, length = 100)
    private String salary_is_predicted;

    @Column(name = "company", nullable = true, length = 100)
    private String company;

    @Column(name = "location", nullable = true, length = 100)
    private String location;

    @Column(name = "category", nullable = true, length = 100)
    private String category;

    @ManyToOne
    @JoinColumn(name="users", nullable=false, updatable=false)
    private UserModel user;
    
    public AdzunaJobModel() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirect_url() {
        return this.redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getSalary_min() {
        return this.salary_min;
    }

    public void setSalary_min(String salary_min) {
        this.salary_min = salary_min;
    }

    public String getSalary_max() {
        return this.salary_max;
    }

    public void setSalary_max(String salary_max) {
        this.salary_max = salary_max;
    }

    public String getContract_time() {
        return this.contract_time;
    }

    public void setContract_time(String contract_time) {
        this.contract_time = contract_time;
    }

    public String getSalary_is_predicted() {
        return this.salary_is_predicted;
    }

    public void setSalary_is_predicted(String salary_is_predicted) {
        this.salary_is_predicted = salary_is_predicted;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

        public AdzunaJobHttpResponse createResponse() {
            AdzunaJobHttpResponse response = new AdzunaJobHttpResponse();
            response.setTitle(this.getTitle());
            response.setDescription(this.getDescription());
            response.setRedirect_url(this.getRedirect_url());
            response.setCreated(this.getCreated());
            response.setSalary_min(this.getSalary_min().toString());
            response.setSalary_max(this.getSalary_max().toString());
            response.setContract_time(this.getContract_time());
            response.setSalary_is_predicted(this.getSalary_is_predicted());
            response.setCompany(this.getCompany());
            response.setLocation(this.getLocation());
            response.setCategory(this.getCategory());
            response.setUserId(this.getUser().getId());
            response.setId(this.getId());
            return response;
    }
}