package com.backend.getyourstart.api.service;
import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.helpers.JSearchRequestHelper;
import com.backend.getyourstart.dto.JSearchJobRequest;
import com.backend.getyourstart.dto.JSearchJob;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class JSearchJobService {
    private JSearchRequestHelper jobRequestHelper;

    public JSearchJobService() {
        this.jobRequestHelper = new JSearchRequestHelper();
    }

    public List<JSearchJob> getJobs(JSearchJobRequest jobRequest) {
        JSearchRequestHelper jobRequestHelper = new JSearchRequestHelper();

        jobRequestHelper.setQuery(
            jobRequest.getJob(),
            jobRequest.getPage(),
            jobRequest.getNumPages(),
            jobRequest.getCountry(),
            jobRequest.getLanguage(),
            jobRequest.getDatePosted(),
            jobRequest.getEmploymentTypes(),
            jobRequest.getJobRequirements(),
            jobRequest.getRadius()
        );

        List<JSearchJob> jsearchJobs = jobRequestHelper.sendRequest();

        return jsearchJobs;
    }

}