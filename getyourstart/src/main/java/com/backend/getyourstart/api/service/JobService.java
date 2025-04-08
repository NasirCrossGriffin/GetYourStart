package com.backend.getyourstart.api.service;
import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.helpers.JobRequestHelper;
import com.backend.getyourstart.dto.JobRequest;
import com.backend.getyourstart.dto.JobObj;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private JobRequestHelper jobRequestHelper;

    public JobService() {
        this.jobRequestHelper = new JobRequestHelper();
    }

    public List<JobObj> getJobs(JobRequest jobRequest) {
        JobRequestHelper jobRequestHelper = new JobRequestHelper();

        jobRequestHelper.setQuery(
            jobRequest.getCountry(),
            jobRequest.getNumResults(),
            jobRequest.getJobTypes(),
            jobRequest.getPage(),
            jobRequest.getWhere(),
            jobRequest.getDistance(),
            jobRequest.getSortBy(),
            jobRequest.getSalaryMin(),
            jobRequest.getSalaryMax(),
            jobRequest.getFullTime(),
            jobRequest.getPartTime(),
            jobRequest.getContract(),
            jobRequest.getPermanent()
        );

        List<JobObj> jobObjects = jobRequestHelper.sendRequest();

        return jobObjects;
    }

}