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

import com.backend.getyourstart.api.service.GYSJobService;
import com.backend.getyourstart.dto.GYSJobResponse;
import com.backend.getyourstart.dto.JobRequest;
import com.backend.getyourstart.dto.SavedGYSJobResponse;

import jakarta.servlet.http.HttpSession;

@RestController
public class JobController {
    private GYSJobService jobService;

    @Autowired
    public JobController(GYSJobService jobService) {
        this.jobService = jobService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/gys/job")
    public ResponseEntity<List<GYSJobResponse>> getJobs(@RequestBody JobRequest jobRequest) {
        List<GYSJobResponse> jobsFound = jobService.getJobs(jobRequest);
        if (jobsFound != null)
            return new ResponseEntity<>(jobsFound, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/gys/job/save")
    public ResponseEntity<SavedGYSJobResponse> saveJob(@RequestBody GYSJobResponse gysJob, HttpSession session) {
        SavedGYSJobResponse savedJobResponse = jobService.saveJob(gysJob, session);
        if (savedJobResponse != null)
            return new ResponseEntity<>(savedJobResponse, HttpStatus.OK);
        else
            return ResponseEntity.badRequest().body(null);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/gys/job/save/get/{userId}")
    public ResponseEntity<List<SavedGYSJobResponse>> getSavedJobs(@PathVariable String userId) {
        List<SavedGYSJobResponse> savedJobs = jobService.getSavedJobs(Long.parseLong(userId));
        if (savedJobs != null)
            return new ResponseEntity<>(savedJobs, HttpStatus.OK);
        else 
            return ResponseEntity.badRequest().body(null);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/gys/job/delete/{jobId}")
    public ResponseEntity<String> deleteSavedJobs(@PathVariable String jobId) {
        boolean jobDeleted = jobService.deleteJob(Long.parseLong(jobId));
        if (jobDeleted == true)
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        else 
            return ResponseEntity.internalServerError().body("Job Deletion Failed");
    }
}

