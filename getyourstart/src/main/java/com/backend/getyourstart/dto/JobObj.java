package com.backend.getyourstart.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobObj {
    public String title;
    public String description;
    public String redirect_url;
    public String created;
    public Double salary_min;
    public Double salary_max;
    public String contract_time;
    public String salary_is_predicted;
    public Company company;
    public Location location;
    public Category category;


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

    public Double getSalary_min() {
        return this.salary_min;
    }

    public void setSalary_min(Double salary_min) {
        this.salary_min = salary_min;
    }

    public Double getSalary_max() {
        return this.salary_max;
    }

    public void setSalary_max(Double salary_max) {
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

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}