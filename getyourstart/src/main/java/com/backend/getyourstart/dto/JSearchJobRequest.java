package com.backend.getyourstart.dto;

public class JSearchJobRequest {
    private String job;
    private String page;
    private String numPages;
    private String country;
    private String language;
    private String datePosted;
    private String employmentTypes;
    private String jobRequirements;
    private String radius;


    public JSearchJobRequest() {

    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getNumPages() {
        return this.numPages;
    }

    public void setNumPages(String numPages) {
        this.numPages = numPages;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDatePosted() {
        return this.datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getEmploymentTypes() {
        return this.employmentTypes;
    }

    public void setEmploymentTypes(String employmentTypes) {
        this.employmentTypes = employmentTypes;
    }

    public String getJobRequirements() {
        return this.jobRequirements;
    }

    public void setJobRequirements(String jobRequirements) {
        this.jobRequirements = jobRequirements;
    }

    public String getRadius() {
        return this.radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

}
