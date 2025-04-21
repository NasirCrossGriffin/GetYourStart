package com.backend.getyourstart.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JSearchJobHighlights {
    private String Qualifications;
    private String Requirements;


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

}
