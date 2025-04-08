package com.backend.getyourstart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.dto.JobObj;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResponse {
    public List<JobObj> results;

    public List<JobObj> getResults() {
        return this.results;
    }

    public void setResults(List<JobObj> results) {
        this.results = results;
    }
}