package com.backend.getyourstart.api.controller;

import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.helpers.JobRequestHelper;
import com.backend.getyourstart.dto.JobRequest;
import com.backend.getyourstart.api.service.JobService;
import com.backend.getyourstart.dto.JobObj;
import java.net.http.HttpResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController() {
        this.jobService = new JobService();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/jobs")
    public ResponseEntity<List<JobObj>> getJobs(@RequestBody JobRequest jobRequest) {
        List<JobObj> jobsFound = jobService.getJobs(jobRequest);
        return new ResponseEntity<>(jobsFound, HttpStatus.OK);
    }
}
