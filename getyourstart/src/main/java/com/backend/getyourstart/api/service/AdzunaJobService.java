package com.backend.getyourstart.api.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.getyourstart.dto.AdzunaJob;
import com.backend.getyourstart.dto.AdzunaJobHttpResponse;
import com.backend.getyourstart.dto.AdzunaJobRequest;
import com.backend.getyourstart.dto.UserResponse;
import com.backend.getyourstart.helpers.AdzunaRequestHelper;
import com.backend.getyourstart.models.AdzunaJobModel;
import com.backend.getyourstart.models.UserModel;
import com.backend.getyourstart.repository.AdzunaJobRepository;
import com.backend.getyourstart.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdzunaJobService {
    final AdzunaJobRepository jobRepository;
    final UserRepository userRepository;
    private AdzunaRequestHelper jobRequestHelper;
    private UserService userService;

    public AdzunaJobService(AdzunaJobRepository jobRepository, UserRepository userRepository, UserService userService) {
        this.jobRequestHelper = new AdzunaRequestHelper();
        this.userService = userService;
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
    }

    public List<AdzunaJob> getJobs(AdzunaJobRequest jobRequest) {
        AdzunaRequestHelper jobRequestHelper = new AdzunaRequestHelper();

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

        List<AdzunaJob> jobObjects = jobRequestHelper.sendRequest();

        return jobObjects;
    }

    public AdzunaJobModel saveJob(AdzunaJob adzunaJob, HttpSession session) {
        AdzunaJobModel adzunaJobModel = new AdzunaJobModel();
        UserResponse userResponse = userService.getLoggedIn(session);
        UserModel user;

        try {
             user = userRepository.getUserById(userResponse.getId()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        adzunaJobModel.setUser(user);
        adzunaJobModel.setTitle(adzunaJob.getTitle());
        adzunaJobModel.setDescription(adzunaJob.getDescription());
        adzunaJobModel.setRedirect_url(adzunaJob.getRedirect_url());
        adzunaJobModel.setCreated(adzunaJob.getCreated());
        adzunaJobModel.setSalary_min(adzunaJob.getSalary_min().toString());
        adzunaJobModel.setSalary_max(adzunaJob.getSalary_max().toString());
        adzunaJobModel.setContract_time(adzunaJob.getContract_time());
        adzunaJobModel.setSalary_is_predicted(adzunaJob.getSalary_is_predicted());
        adzunaJobModel.setCompany(adzunaJob.getCompany().getDisplay_name());
        adzunaJobModel.setLocation(adzunaJob.getLocation().getDisplay_name());
        adzunaJobModel.setCategory(adzunaJob.getCategory().getLabel());

        try {
            jobRepository.save(adzunaJobModel);
        } catch (Exception e) {
            return null;
        }

        return adzunaJobModel;
    }

    public List<AdzunaJobHttpResponse> getSavedJobs(String userId) {
        UserModel user = userRepository.getUserById(Long.parseLong(userId)).get();

        List<AdzunaJobModel> adzunaJobs = jobRepository.getAdzunaJobsByUser(user);
        List<AdzunaJobHttpResponse> adzunaJobResponses = new ArrayList<AdzunaJobHttpResponse>();

        adzunaJobs.forEach((job) -> {
            adzunaJobResponses.add(job.createResponse());
        });

        return adzunaJobResponses;
    }

    public boolean deleteJob(Long adzunaJobId) {
        AdzunaJobModel retrievedAdzunaJob = getAdzunaJobMiddleware(adzunaJobId);

        if (retrievedAdzunaJob == null) {
            return false;
        }

        try {
            jobRepository.delete(retrievedAdzunaJob); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public AdzunaJobModel getAdzunaJobMiddleware(Long jobId) {
        AdzunaJobModel retrievedJob = null;

        try {
            retrievedJob = jobRepository.getAdzunaJobById(jobId).get();
        } catch (Exception e) {
            return null;
        }

        return retrievedJob;
    }


}