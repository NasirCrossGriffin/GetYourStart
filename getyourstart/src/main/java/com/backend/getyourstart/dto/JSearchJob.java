package com.backend.getyourstart.dto;
import java.util.ArrayList;
import java.util.List;

import com.backend.getyourstart.models.JSearchJobModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSearchJob {
    private String job_id;
    private String employer_name;
    private String employer_logo;
    private String employer_website;
    private String employer_company_type;
    private String employer_linkedin;
    private String job_publisher;
    private String job_employment_type;
    private List<String> job_employment_types;
    private String job_employment_type_text;
    private String job_title;
    private String job_apply_link;
    private String job_description;
    private Boolean job_is_remote;
    private String job_posted_human_readable;
    private String job_location;
    private String job_city;
    private String job_state;
    private String job_country;
    private List<String> job_benefits;
    private String job_google_link;
    private String job_offer_expiration_datetime_utc;
    private String job_salary;
    private Double job_min_salary;
    private Double job_max_salary;
    private String job_salary_currency;
    private String job_salary_period;
    private JSearchJobHighlights job_highlights;


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

    public List<String> getJob_employment_types() {
        return this.job_employment_types;
    }

    public void setJob_employment_types(List<String> job_employment_types) {
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

    public List<String> getJob_benefits() {
        return this.job_benefits;
    }

    public void setJob_benefits(List<String> job_benefits) {
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

    public JSearchJobHighlights getJob_highlights() {
        return this.job_highlights;
    }

    public void setJob_highlights(JSearchJobHighlights job_highlights) {
        this.job_highlights = job_highlights;
    }

    public static JSearchJobModel createModel(JSearchJob job) {
        JSearchJobModel model = new JSearchJobModel();
        
        model.setJob_id(job.getJob_id());
        model.setEmployer_name(job.getEmployer_name());
        model.setEmployer_logo(job.getEmployer_logo());
        model.setEmployer_website(job.getEmployer_website());
        model.setEmployer_company_type(job.getEmployer_company_type());
        model.setEmployer_linkedin(job.getEmployer_linkedin());
        model.setJob_publisher(job.getJob_publisher());
        model.setJob_employment_type(job.getJob_employment_type());

        // Convert List<String> to comma-separated string
        model.setJob_employment_types(String.join(",", job.getJob_employment_types() != null ? job.getJob_employment_types() : new ArrayList<>()));
        model.setJob_benefits(String.join(",", job.getJob_benefits() != null ? job.getJob_benefits() : new ArrayList<>()));

        model.setJob_employment_type_text(job.getJob_employment_type_text());
        model.setJob_title(job.getJob_title());
        model.setJob_apply_link(job.getJob_apply_link());
        model.setJob_description(job.getJob_description());
        model.setJob_is_remote(job.getJob_is_remote());
        model.setJob_posted_human_readable(job.getJob_posted_human_readable());
        model.setJob_location(job.getJob_location());
        model.setJob_city(job.getJob_city());
        model.setJob_state(job.getJob_state());
        model.setJob_country(job.getJob_country());
        model.setJob_google_link(job.getJob_google_link());
        model.setJob_offer_expiration_datetime_utc(job.getJob_offer_expiration_datetime_utc());
        model.setJob_salary(job.getJob_salary());
        model.setJob_min_salary(job.getJob_min_salary());
        model.setJob_max_salary(job.getJob_max_salary());
        model.setJob_salary_currency(job.getJob_salary_currency());
        model.setJob_salary_period(job.getJob_salary_period());

        // If your Qualifications and Requirements come from highlights
        if (job.getJob_highlights() != null) {
            model.setQualifications(String.join(",", job.getJob_highlights().getQualifications()));
            model.setRequirements(String.join(",", job.getJob_highlights().getRequirements()));
        }

        return model;
    }

        public GYSJobResponse toGYSJobResponse() {
        GYSJobResponse gysJob = new GYSJobResponse();

        gysJob.setSourceApi("jsearch");
        gysJob.setTitle(this.getJob_title());
        gysJob.setDescription(this.getJob_description());
        gysJob.setApplyLink(this.getJob_apply_link());
        gysJob.setEmployerName(this.getEmployer_name());
        gysJob.setLocation(this.getJob_location());
        gysJob.setRemote(this.getJob_is_remote());
        gysJob.setPostedDate(this.getJob_posted_human_readable());
        gysJob.setSalaryMin(this.getJob_min_salary());
        gysJob.setSalaryMax(this.getJob_max_salary());
        gysJob.setSalaryCurrency(this.getJob_salary_currency());
        gysJob.setSalaryPeriod(this.getJob_salary_period());
        gysJob.setJobType(this.getJob_employment_type());
        gysJob.setBenefits(this.getJob_benefits() != null ? String.join(", ", this.getJob_benefits()) : null);
        gysJob.setRequirements(this.getJob_highlights() != null ? this.getJob_highlights().getRequirements() : null);
        gysJob.setQualifications(this.getJob_highlights() != null ? this.getJob_highlights().getQualifications() : null);

        return gysJob;
    }


}
