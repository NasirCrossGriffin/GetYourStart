package com.backend.getyourstart.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.dto.AdzunaJob;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdzunaJobResponse {
    public List<AdzunaJob> results;

    public List<AdzunaJob> getResults() {
        return this.results;
    }

    public void setResults(List<AdzunaJob> results) {
        this.results = results;
    }
}