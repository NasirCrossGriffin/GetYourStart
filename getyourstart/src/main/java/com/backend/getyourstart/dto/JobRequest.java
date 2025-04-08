package com.backend.getyourstart.dto;

import java.util.List;

public class JobRequest {
    public String country; 
    public String numResults; 
    public List<String> jobTypes; 
    public String page; 
    public String where; 
    public String distance;
    public String sortBy;
    public String salaryMin;
    public String salaryMax;
    public String fullTime;
    public String partTime;
    public String contract;
    public String permanent;

    public JobRequest() {

    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumResults() {
        return this.numResults;
    }

    public void setNumResults(String numResults) {
        this.numResults = numResults;
    }

    public List<String> getJobTypes() {
        return this.jobTypes;
    }

    public void setJobTypes(List<String> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getWhere() {
        return this.where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSalaryMin() {
        return this.salaryMin;
    }

    public void setSalaryMin(String salaryMin) {
        this.salaryMin = salaryMin;
    }

    public String getSalaryMax() {
        return this.salaryMax;
    }

    public void setSalaryMax(String salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getFullTime() {
        return this.fullTime;
    }

    public void setFullTime(String fullTime) {
        this.fullTime = fullTime;
    }

    public String getPartTime() {
        return this.partTime;
    }

    public void setPartTime(String partTime) {
        this.partTime = partTime;
    }

    public String getContract() {
        return this.contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getPermanent() {
        return this.permanent;
    }

    public void setPermanent(String permanent) {
        this.permanent = permanent;
    }
}