package com.backend.getyourstart.models;
import com.backend.getyourstart.dto.JSearchJobHttpResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jsearch_jobs")
public class JSearchJobModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "job_id", nullable = false, length = 255)
    private String job_id;

    @Column(name = "employer_name", nullable = false, length = 100)
    private String employer_name;

    @Column(name = "employer_logo", length = 100)
    private String employer_logo;

    @Column(name = "employer_website", length = 100)
    private String employer_website;

    @Column(name = "employer_company_type", length = 100)
    private String employer_company_type;

    @Column(name = "employer_linkedin", length = 255)
    private String employer_linkedin;

    @Column(name = "job_publisher", length = 100)
    private String job_publisher;

    @Column(name = "job_employment_type", length = 100)
    private String job_employment_type;

    @Column(name = "job_employment_types", length = 255)
    private String job_employment_types;

    @Column(name = "job_employment_type_text", length = 255)
    private String job_employment_type_text;

    @Column(name = "job_title", length = 255)
    private String job_title;

    @Column(name = "job_apply_link", length = 500)
    private String job_apply_link;

    @Lob
    @Column(name = "job_description", columnDefinition = "TEXT")
    private String job_description;

    @Column(name = "job_is_remote")
    private Boolean job_is_remote;

    @Column(name = "job_posted_human_readable", length = 100)
    private String job_posted_human_readable;

    @Column(name = "job_location", length = 255)
    private String job_location;

    @Column(name = "job_city", length = 100)
    private String job_city;

    @Column(name = "job_state", length = 100)
    private String job_state;

    @Column(name = "job_country", length = 100)
    private String job_country;

    @Lob
    @Column(name = "job_benefits", columnDefinition = "TEXT")
    private String job_benefits;

    @Column(name = "job_google_link", length = 500)
    private String job_google_link;

    @Column(name = "job_offer_expiration_datetime_utc", length = 100)
    private String job_offer_expiration_datetime_utc;

    @Column(name = "job_salary", length = 100)
    private String job_salary;

    @Column(name = "job_min_salary")
    private Double job_min_salary;

    @Column(name = "job_max_salary")
    private Double job_max_salary;

    @Column(name = "job_salary_currency", length = 10)
    private String job_salary_currency;

    @Column(name = "job_salary_period", length = 50)
    private String job_salary_period;

    @Lob
    @Column(name = "Qualifications", columnDefinition = "TEXT")
    private String Qualifications;

    @Lob
    @Column(name = "Requirements", columnDefinition = "TEXT")
    private String Requirements;

    @ManyToOne
    @JoinColumn(name="users", nullable=false, updatable=false)
    private UserModel user;

    public JSearchJobModel() {

    }


    public String getJob_id() {
        return this.job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getEmployer_name() {
        return this.employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getEmployer_logo() {
        return this.employer_logo;
    }

    public void setEmployer_logo(String employer_logo) {
        this.employer_logo = employer_logo;
    }

    public String getEmployer_website() {
        return this.employer_website;
    }

    public void setEmployer_website(String employer_website) {
        this.employer_website = employer_website;
    }

    public String getEmployer_company_type() {
        return this.employer_company_type;
    }

    public void setEmployer_company_type(String employer_company_type) {
        this.employer_company_type = employer_company_type;
    }

    public String getEmployer_linkedin() {
        return this.employer_linkedin;
    }

    public void setEmployer_linkedin(String employer_linkedin) {
        this.employer_linkedin = employer_linkedin;
    }

    public String getJob_publisher() {
        return this.job_publisher;
    }

    public void setJob_publisher(String job_publisher) {
        this.job_publisher = job_publisher;
    }

    public String getJob_employment_type() {
        return this.job_employment_type;
    }

    public void setJob_employment_type(String job_employment_type) {
        this.job_employment_type = job_employment_type;
    }

    public String getJob_employment_types() {
        return this.job_employment_types;
    }

    public void setJob_employment_types(String job_employment_types) {
        this.job_employment_types = job_employment_types;
    }

    public String getJob_employment_type_text() {
        return this.job_employment_type_text;
    }

    public void setJob_employment_type_text(String job_employment_type_text) {
        this.job_employment_type_text = job_employment_type_text;
    }

    public String getJob_title() {
        return this.job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_apply_link() {
        return this.job_apply_link;
    }

    public void setJob_apply_link(String job_apply_link) {
        this.job_apply_link = job_apply_link;
    }

    public String getJob_description() {
        return this.job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public Boolean isJob_is_remote() {
        return this.job_is_remote;
    }

    public Boolean getJob_is_remote() {
        return this.job_is_remote;
    }

    public void setJob_is_remote(Boolean job_is_remote) {
        this.job_is_remote = job_is_remote;
    }

    public String getJob_posted_human_readable() {
        return this.job_posted_human_readable;
    }

    public void setJob_posted_human_readable(String job_posted_human_readable) {
        this.job_posted_human_readable = job_posted_human_readable;
    }

    public String getJob_location() {
        return this.job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getJob_city() {
        return this.job_city;
    }

    public void setJob_city(String job_city) {
        this.job_city = job_city;
    }

    public String getJob_state() {
        return this.job_state;
    }

    public void setJob_state(String job_state) {
        this.job_state = job_state;
    }

    public String getJob_country() {
        return this.job_country;
    }

    public void setJob_country(String job_country) {
        this.job_country = job_country;
    }

    public String getJob_benefits() {
        return this.job_benefits;
    }

    public void setJob_benefits(String job_benefits) {
        this.job_benefits = job_benefits;
    }

    public String getJob_google_link() {
        return this.job_google_link;
    }

    public void setJob_google_link(String job_google_link) {
        this.job_google_link = job_google_link;
    }

    public String getJob_offer_expiration_datetime_utc() {
        return this.job_offer_expiration_datetime_utc;
    }

    public void setJob_offer_expiration_datetime_utc(String job_offer_expiration_datetime_utc) {
        this.job_offer_expiration_datetime_utc = job_offer_expiration_datetime_utc;
    }

    public String getJob_salary() {
        return this.job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
    }

    public Double getJob_min_salary() {
        return this.job_min_salary;
    }

    public void setJob_min_salary(Double job_min_salary) {
        this.job_min_salary = job_min_salary;
    }

    public Double getJob_max_salary() {
        return this.job_max_salary;
    }

    public void setJob_max_salary(Double job_max_salary) {
        this.job_max_salary = job_max_salary;
    }

    public String getJob_salary_currency() {
        return this.job_salary_currency;
    }

    public void setJob_salary_currency(String job_salary_currency) {
        this.job_salary_currency = job_salary_currency;
    }

    public String getJob_salary_period() {
        return this.job_salary_period;
    }

    public void setJob_salary_period(String job_salary_period) {
        this.job_salary_period = job_salary_period;
    }

    public String getQualifications() {
        return this.Qualifications;
    }

    public void setQualifications(String Qualifications) {
        this.Qualifications = Qualifications;
    }

    public String getRequirements() {
        return this.Requirements;
    }

    public void setRequirements(String Requirements) {
        this.Requirements = Requirements;
    }

    public UserModel user() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public JSearchJobHttpResponse createResponse() {
        JSearchJobHttpResponse response = new JSearchJobHttpResponse();
        
        response.setId(this.id.toString());
        response.setJob_id(this.job_id);
        response.setEmployer_name(this.employer_name);
        response.setEmployer_logo(this.employer_logo);
        response.setEmployer_website(this.employer_website);
        response.setEmployer_company_type(this.employer_company_type);
        response.setEmployer_linkedin(this.employer_linkedin);
        response.setJob_publisher(this.job_publisher);
        response.setJob_employment_type(this.job_employment_type);
        response.setJob_employment_types(this.job_employment_types);
        response.setJob_employment_type_text(this.job_employment_type_text);
        response.setJob_title(this.job_title);
        response.setJob_apply_link(this.job_apply_link);
        response.setJob_description(this.job_description);
        response.setJob_is_remote(this.job_is_remote);
        response.setJob_posted_human_readable(this.job_posted_human_readable);
        response.setJob_location(this.job_location);
        response.setJob_city(this.job_city);
        response.setJob_state(this.job_state);
        response.setJob_country(this.job_country);
        response.setJob_benefits(this.job_benefits);
        response.setJob_google_link(this.job_google_link);
        response.setJob_offer_expiration_datetime_utc(this.job_offer_expiration_datetime_utc);
        response.setJob_salary(this.job_salary);
        response.setJob_min_salary(this.job_min_salary);
        response.setJob_max_salary(this.job_max_salary);
        response.setJob_salary_currency(this.job_salary_currency);
        response.setJob_salary_period(this.job_salary_period);
        response.setQualifications(this.Qualifications);
        response.setRequirements(this.Requirements);
        response.setUserId(this.user.getId()); 
    
        return response;
    }

    public SavedGYSJobModel convertFromJSearch() {
        SavedGYSJobModel gys = new SavedGYSJobModel();
        gys.setSourceApi("jsearch");
        gys.setTitle(this.getJob_title());
        gys.setDescription(this.getJob_description());
        gys.setApplyLink(this.getJob_apply_link());
        gys.setEmployerName(this.getEmployer_name());
        gys.setEmployerLogo(this.getEmployer_logo());
        gys.setLocation(this.getJob_location());
        gys.setRemote(this.getJob_is_remote());
        gys.setPostedDate(this.getJob_posted_human_readable());
        gys.setSalaryMin(this.getJob_min_salary());
        gys.setSalaryMax(this.getJob_max_salary());
        gys.setSalaryCurrency(this.getJob_salary_currency());
        gys.setSalaryPeriod(this.getJob_salary_period());
        gys.setJobType(this.getJob_employment_type());
        gys.setBenefits(this.getJob_benefits());
        gys.setQualifications(this.getQualifications());
        gys.setRequirements(this.getRequirements());
        gys.setUser(this.user()); // inherited from relationship
        return gys;
    }

}