package com.backend.getyourstart.models;

import com.backend.getyourstart.dto.GYSJobResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gys_jobs")
public class GYSJobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_api", nullable = false, length = 50)
    private String sourceApi; // e.g., "adzuna" or "jsearch"

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "apply_link", length = 500)
    private String applyLink;

    @Column(name = "employer_name", length = 255)
    private String employerName;

    @Column(name = "employer_logo", length = 255)
    private String employerLogo;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "remote")
    private Boolean remote;

    @Column(name = "posted_date", length = 100)
    private String postedDate;

    @Column(name = "salary_min")
    private Double salaryMin;

    @Column(name = "salary_max")
    private Double salaryMax;

    @Column(name = "salary_currency", length = 10)
    private String salaryCurrency;

    @Column(name = "salary_period", length = 50)
    private String salaryPeriod;

    @Column(name = "job_type", length = 100)
    private String jobType;

    @Column(name = "benefits", columnDefinition = "TEXT")
    private String benefits;

    @Column(name = "requirements", columnDefinition = "TEXT")
    private String requirements;

    @Column(name = "qualifications", columnDefinition = "TEXT")
    private String qualifications;

    // Getters & Setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceApi() {
        return this.sourceApi;
    }

    public void setSourceApi(String sourceApi) {
        this.sourceApi = sourceApi;
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

    public String getApplyLink() {
        return this.applyLink;
    }

    public void setApplyLink(String applyLink) {
        this.applyLink = applyLink;
    }

    public String getEmployerName() {
        return this.employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerLogo() {
        return this.employerLogo;
    }

    public void setEmployerLogo(String employerLogo) {
        this.employerLogo = employerLogo;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getRemote() {
        return this.remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public String getPostedDate() {
        return this.postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public Double getSalaryMin() {
        return this.salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return this.salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public String getSalaryCurrency() {
        return this.salaryCurrency;
    }

    public void setSalaryCurrency(String salaryCurrency) {
        this.salaryCurrency = salaryCurrency;
    }

    public String getSalaryPeriod() {
        return this.salaryPeriod;
    }

    public void setSalaryPeriod(String salaryPeriod) {
        this.salaryPeriod = salaryPeriod;
    }

    public String getJobType() {
        return this.jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getBenefits() {
        return this.benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getQualifications() {
        return this.qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    // Convert to DTO
    public GYSJobResponse createResponse() {
        GYSJobResponse response = new GYSJobResponse();
        response.setId(this.getId());
        response.setSourceApi(this.getSourceApi());
        response.setTitle(this.getTitle());
        response.setDescription(this.getDescription());
        response.setApplyLink(this.getApplyLink());
        response.setEmployerName(this.getEmployerName());
        response.setEmployerLogo(this.getEmployerLogo());
        response.setLocation(this.getLocation());
        response.setRemote(this.getRemote());
        response.setPostedDate(this.getPostedDate());
        response.setSalaryMin(this.getSalaryMin());
        response.setSalaryMax(this.getSalaryMax());
        response.setSalaryCurrency(this.getSalaryCurrency());
        response.setSalaryPeriod(this.getSalaryPeriod());
        response.setJobType(this.getJobType());
        response.setBenefits(this.getBenefits());
        response.setRequirements(this.getRequirements());
        response.setQualifications(this.getQualifications());
        return response;
    }
}
