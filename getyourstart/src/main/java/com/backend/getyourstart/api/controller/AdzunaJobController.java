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

import com.backend.getyourstart.api.service.AdzunaJobService;
import com.backend.getyourstart.dto.AdzunaJob;
import com.backend.getyourstart.dto.AdzunaJobHttpResponse;
import com.backend.getyourstart.dto.AdzunaJobRequest;
import com.backend.getyourstart.models.AdzunaJobModel;

import jakarta.servlet.http.HttpSession;

@RestController
public class AdzunaJobController {
    private AdzunaJobService jobService;

    @Autowired
    public AdzunaJobController(AdzunaJobService jobService) {
        this.jobService = jobService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job")
    public ResponseEntity<List<AdzunaJob>> getJobs(@RequestBody AdzunaJobRequest jobRequest) {
        List<AdzunaJob> jobsFound = jobService.getJobs(jobRequest);
        if (jobsFound != null)
            return new ResponseEntity<>(jobsFound, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job/save")
    public ResponseEntity<AdzunaJobHttpResponse> saveJob(@RequestBody AdzunaJob adzunaJob, HttpSession session) {
        AdzunaJobModel savedJob = jobService.saveJob(adzunaJob, session);
        AdzunaJobHttpResponse savedJobResponse = savedJob.createResponse();
        if (savedJobResponse != null)
            return new ResponseEntity<>(savedJobResponse, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/adzuna/job/save/get/{userId}")
    public ResponseEntity<List<AdzunaJobHttpResponse>> getSavedJobs(@PathVariable String userId) {
        List<AdzunaJobHttpResponse> savedAdzunaJobs = jobService.getSavedJobs(userId);
        if (savedAdzunaJobs != null)
            return new ResponseEntity<>(savedAdzunaJobs, HttpStatus.OK);
        else 
            return ResponseEntity.badRequest().body(null);

    }
}
