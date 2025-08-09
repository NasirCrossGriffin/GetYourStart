package com.backend.getyourstart.api.service;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math.*;

import org.springframework.stereotype.Service;

import com.backend.getyourstart.dto.AdzunaJob;
import com.backend.getyourstart.dto.GYSJobResponse;
import com.backend.getyourstart.dto.JSearchJob;
import com.backend.getyourstart.dto.JobRequest;
import com.backend.getyourstart.dto.SavedGYSJobResponse;
import com.backend.getyourstart.dto.UserResponse;
import com.backend.getyourstart.helpers.AdzunaRequestHelper;
import com.backend.getyourstart.helpers.JSearchRequestHelper;
import com.backend.getyourstart.models.SavedGYSJobModel;
import com.backend.getyourstart.models.UserModel;
import com.backend.getyourstart.repository.AdzunaJobRepository;
import com.backend.getyourstart.repository.GYSJobRepository;
import com.backend.getyourstart.repository.JSearchJobRepository;
import com.backend.getyourstart.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class GYSJobService {
    final AdzunaJobRepository adzunaJobRepository;
    final JSearchJobRepository jsearchJobRepository;
    final GYSJobRepository gysJobRepository;
    final UserRepository userRepository;
    private AdzunaRequestHelper adzunaJobRequestHelper;
    private JSearchRequestHelper jsearchJobRequestHelper;
    private UserService userService;

    public GYSJobService(GYSJobRepository gysJobRepository, JSearchJobRepository jsearchJobRepository, AdzunaJobRepository adzunaJobRepository, UserRepository userRepository, UserService userService) {
        this.adzunaJobRequestHelper = new AdzunaRequestHelper();
        this.userService = userService;
        this.gysJobRepository = gysJobRepository;
        this.jsearchJobRepository = jsearchJobRepository;
        this.userRepository = userRepository;
        this.adzunaJobRepository = adzunaJobRepository;
        this.jsearchJobRequestHelper = new JSearchRequestHelper();
        this.userService = userService;
    }

    public List<GYSJobResponse> getJobs(JobRequest jobRequest) {
        AdzunaRequestHelper jobRequestHelper = new AdzunaRequestHelper();

        List<String> jobTypes = new ArrayList<>(); 
        jobTypes.add(jobRequest.getJobTitle());

        this.adzunaJobRequestHelper.setQuery(
            jobRequest.getCountry(),
            "50",
            jobTypes,
            "1",
            jobRequest.getWhere(),
            jobRequest.getDistance().toString(),
            jobRequest.getSortBy(),
            new Integer(new Double(jobRequest.getSalaryMin()).intValue()).toString(),
            new Integer(new Double(jobRequest.getSalaryMax()).intValue()).toString(),
            jobRequest.getFullTime() == true ? "1" : null,
            jobRequest.getPartTime() == true ? "1" : null,
            jobRequest.getContract() == true ? "1" : null,
            jobRequest.getPermanent() == true ? "1" : null
        );

         StringBuilder jobString = new StringBuilder(jobRequest.getJobTitle());
         jobString.append(" in ");
         jobString.append(jobRequest.getWhere());

        this.jsearchJobRequestHelper.setQuery(
            jobRequest.getJobTitle(),
            "1",
            "1",
            jobRequest.getCountry(),
            "en",
            "all",
            "FULLTIME",
            "no_experience",
            jobRequest.getDistance().toString()
        );

        List<AdzunaJob> adzunaJobObjects = this.adzunaJobRequestHelper.sendRequest();
        List<JSearchJob> jsearchJobObjects = this.jsearchJobRequestHelper.sendRequest();

        //Convert to GYS Jobs

        List<GYSJobResponse> gysJobs = new ArrayList<>();

        adzunaJobObjects.forEach(adzunaJob -> gysJobs.add(adzunaJob.toGYSJobResponse()));
        jsearchJobObjects.forEach(jsearchJob -> gysJobs.add(jsearchJob.toGYSJobResponse()));

        return gysJobs;
    }

    public SavedGYSJobResponse saveJob(GYSJobResponse gysJobRequest, HttpSession session) {
        SavedGYSJobModel gysJob = new SavedGYSJobModel();
        UserResponse userResponse = userService.getLoggedIn(session);
        UserModel user;

        try {
             user = userRepository.getUserById(userResponse.getId()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if (user == null) {
            return null;
        }

        // Populate the model fields
        gysJob.setSourceApi(gysJobRequest.getSourceApi());
        gysJob.setTitle(gysJobRequest.getTitle());
        gysJob.setDescription(gysJobRequest.getDescription());
        gysJob.setApplyLink(gysJobRequest.getApplyLink());
        gysJob.setEmployerName(gysJobRequest.getEmployerName());
        gysJob.setEmployerLogo(gysJobRequest.getEmployerLogo());
        gysJob.setLocation(gysJobRequest.getLocation());
        gysJob.setRemote(gysJobRequest.getRemote());
        gysJob.setPostedDate(gysJobRequest.getPostedDate());
        gysJob.setSalaryMin(gysJobRequest.getSalaryMin());
        gysJob.setSalaryMax(gysJobRequest.getSalaryMax());
        gysJob.setSalaryCurrency(gysJobRequest.getSalaryCurrency());
        gysJob.setSalaryPeriod(gysJobRequest.getSalaryPeriod());
        gysJob.setJobType(gysJobRequest.getJobType());
        gysJob.setBenefits(gysJobRequest.getBenefits());
        gysJob.setRequirements(gysJobRequest.getRequirements());
        gysJob.setQualifications(gysJobRequest.getQualifications());
        gysJob.setUser(user);

        // Save the job
        SavedGYSJobModel newSavedGysJob = gysJobRepository.save(gysJob);

        return newSavedGysJob.createResponse();
    }

    public List<SavedGYSJobResponse> getSavedJobs(Long userId) {
        UserModel user = userRepository.getUserById(userId).get();
        List<SavedGYSJobModel> savedJobs = gysJobRepository.getGYSJobsByUser(user);

        if (savedJobs == null || savedJobs.isEmpty()) {
            return null;
        }

        List<SavedGYSJobResponse> savedJobResponses = new ArrayList<>();

        savedJobs.forEach(savedJob -> savedJobResponses.add(savedJob.createResponse()));

        return savedJobResponses;
    }

    public boolean deleteJob(Long jobId) {
        SavedGYSJobModel retrievedJob = gysJobRepository.getGYSJobById(jobId).get();

        if (retrievedJob == null) {
            return false;
        }

        try {
            gysJobRepository.delete(retrievedJob); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
