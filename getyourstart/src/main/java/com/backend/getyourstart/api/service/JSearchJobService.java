package com.backend.getyourstart.api.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.getyourstart.dto.JSearchJob;
import com.backend.getyourstart.dto.JSearchJobHttpResponse;
import com.backend.getyourstart.dto.JSearchJobRequest;
import com.backend.getyourstart.dto.UserResponse;
import com.backend.getyourstart.helpers.JSearchRequestHelper;
import com.backend.getyourstart.models.AdzunaJobModel;
import com.backend.getyourstart.models.JSearchJobModel;
import com.backend.getyourstart.models.UserModel;
import com.backend.getyourstart.repository.JSearchJobRepository;
import com.backend.getyourstart.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class JSearchJobService {
    final JSearchJobRepository jobRepository;
    final UserRepository userRepository;
    private JSearchRequestHelper jobRequestHelper;
    private UserService userService;


    public JSearchJobService(JSearchJobRepository jobRepository, UserRepository userRepository, UserService userService) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.jobRequestHelper = new JSearchRequestHelper();
        this.userService = userService;
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

    public JSearchJobModel saveJob(JSearchJob jSearchJob, HttpSession session) {
        JSearchJobModel jSearchJobModel = new JSearchJobModel();
        UserResponse userResponse = userService.getLoggedIn(session);
        UserModel user = null;

        try {
             user = userRepository.getUserById(userResponse.getId()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        JSearchJobModel newModel = JSearchJob.createModel(jSearchJob);
        newModel.setUser(user);

        JSearchJobModel savedModel = null;

        try {
            savedModel = jobRepository.save(newModel);
        } catch (Exception e) {
            return null;
        }

        return savedModel;
    }

    @Transactional
    public List<JSearchJobHttpResponse> getSavedJobs(String userId) {
        UserModel user = userRepository.getUserById(Long.parseLong(userId)).get();

        List<JSearchJobModel> jsearchJobs = jobRepository.getJSearchJobsByUser(user);
        List<JSearchJobHttpResponse> jsearchJobResponses = new ArrayList<JSearchJobHttpResponse>();

        jsearchJobs.forEach((job) -> {
            jsearchJobResponses.add(job.createResponse());
        });

        return jsearchJobResponses;
    }

    public boolean deleteJob(Long jsearchJobId) {
        JSearchJobModel retrievedJSearchJob = getJSearchJobMiddleware(jsearchJobId);

        if (retrievedJSearchJob == null) {
            return false;
        }

        try {
            jobRepository.delete(retrievedJSearchJob); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public JSearchJobModel getJSearchJobMiddleware(Long jobId) {
        JSearchJobModel retrievedJob = null;

        try {
            retrievedJob = jobRepository.getJSearchJobById(jobId).get();
        } catch (Exception e) {
            return null;
        }

        return retrievedJob;
    }

}

