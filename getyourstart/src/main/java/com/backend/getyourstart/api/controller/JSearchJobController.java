package com.backend.getyourstart.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.getyourstart.api.service.JSearchJobService;
import com.backend.getyourstart.dto.JSearchJob;
import com.backend.getyourstart.dto.JSearchJobHttpResponse;
import com.backend.getyourstart.dto.JSearchJobRequest;
import com.backend.getyourstart.models.JSearchJobModel;

import jakarta.servlet.http.HttpSession;

@RestController
public class JSearchJobController {
    private JSearchJobService jobService;

    @Autowired
    public JSearchJobController(JSearchJobService jobService) {
        this.jobService = jobService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/jsearch/job")
    public ResponseEntity<List<JSearchJob>> getJobs(@RequestBody JSearchJobRequest jobRequest) {
        List<JSearchJob> jobsFound = jobService.getJobs(jobRequest);
        if (jobsFound != null)
            return new ResponseEntity<>(jobsFound, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/jsearch/job/save")
    public ResponseEntity<JSearchJobHttpResponse> saveJob(@RequestBody JSearchJob jsearchJob, HttpSession session) {
        JSearchJobModel savedJob = jobService.saveJob(jsearchJob, session);
        JSearchJobHttpResponse savedJobResponse = savedJob.createResponse();
        if (savedJobResponse != null)
            return new ResponseEntity<>(savedJobResponse, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/jsearch/job/save/get/{userId}")
    public ResponseEntity<List<JSearchJobHttpResponse>> getSavedJobs(@PathVariable String userId) {
        List<JSearchJobHttpResponse> savedJSearchJobs = jobService.getSavedJobs(userId);
        if (savedJSearchJobs != null)
            return new ResponseEntity<>(savedJSearchJobs, HttpStatus.OK);
        else 
            return ResponseEntity.badRequest().body(null);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/jsearch/job/delete/{jobId}")
    public ResponseEntity<String> deleteSavedJobs(@PathVariable String jobId) {
        boolean jobDeleted = jobService.deleteJob(Long.parseLong(jobId));;
        if (jobDeleted = true)
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        else 
            return ResponseEntity.internalServerError().body("Job Deletion Failed");

    }
}
