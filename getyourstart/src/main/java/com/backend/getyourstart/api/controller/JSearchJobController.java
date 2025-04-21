package com.backend.getyourstart.api.controller;

import java.util.List;
import java.util.ArrayList;
import com.backend.getyourstart.helpers.JSearchRequestHelper;
import com.backend.getyourstart.dto.JSearchJobRequest;
import com.backend.getyourstart.api.service.JSearchJobService;
import com.backend.getyourstart.dto.JSearchJob;
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
public class JSearchJobController {
    private JSearchJobService jobService;

    @Autowired
    public JSearchJobController() {
        this.jobService = new JSearchJobService();
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

    
}
