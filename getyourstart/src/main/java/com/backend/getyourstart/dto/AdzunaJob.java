package com.backend.getyourstart.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdzunaJob {
    private String title;
    private String description;
    private String redirect_url;
    private String created;
    private Double salary_min;
    private Double salary_max;
    private String contract_time;
    private String salary_is_predicted;
    private AdzunaCompany company;
    private AdzunaLocation location;
    private AdzunaCategory category;


    public AdzunaJob() {
        
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

    public AdzunaCompany getCompany() {
        return this.company;
    }

    public void setCompany(AdzunaCompany company) {
        this.company = company;
    }

    public AdzunaLocation getLocation() {
        return this.location;
    }

    public void setLocation(AdzunaLocation location) {
        this.location = location;
    }

    public AdzunaCategory getCategory() {
        return this.category;
    }

    public void setCategory(AdzunaCategory category) {
        this.category = category;
    }

}