package com.backend.getyourstart.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.dto.JSearchJob;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JSearchJobResponse {
    public List<JSearchJob> data;

    public List<JSearchJob> getData() {
        return this.data;
    }

    public void setData(List<JSearchJob> data) {
        this.data = data;
    }

}
