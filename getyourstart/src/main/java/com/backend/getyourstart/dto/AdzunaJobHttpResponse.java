package com.backend.getyourstart.dto;

public class AdzunaJobHttpResponse {
    private String title;
    private String description;
    private String redirect_url;
    private String created;
    private String salary_min;
    private String salary_max;
    private String contract_time;
    private String salary_is_predicted;
    private String company;
    private String location;
    private String category;
    private Long userId;
    private Long id;


    public AdzunaJobHttpResponse() {

    }


    public AdzunaJobHttpResponse(String title, String description, String redirect_url, String created, String salary_min, String salary_max, String contract_time, String salary_is_predicted, String company, String location, String category, Long id, Long userId) {
        this.title = title;
        this.description = description;
        this.redirect_url = redirect_url;
        this.created = created;
        this.salary_min = salary_min;
        this.salary_max = salary_max;
        this.contract_time = contract_time;
        this.salary_is_predicted = salary_is_predicted;
        this.company = company;
        this.location = location;
        this.category = category;
        this.userId = userId;
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
