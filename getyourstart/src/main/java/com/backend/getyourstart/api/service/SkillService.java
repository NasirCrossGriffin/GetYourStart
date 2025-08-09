package com.backend.getyourstart.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.getyourstart.dto.SkillsResponse;
import com.backend.getyourstart.models.SkillsModel;
import com.backend.getyourstart.models.UserModel;
import com.backend.getyourstart.repository.SkillsRepository;

@Service
public class SkillService {
    private final SkillsRepository skillsRepository;
    private UserService userService;


    public SkillService(SkillsRepository skillsRepository, UserService userService) {
        this.skillsRepository = skillsRepository;
        this.userService = userService;
    }

    public List<SkillsResponse> getSkillsByUser(Long userId) {
        UserModel user = userService.getUserMiddleware(userId);

        if (user == null)
            return null;

        List<SkillsModel> listOfSkills = skillsRepository.getSkillsByUser(user);

        if (listOfSkills == null || listOfSkills.isEmpty())
            return null;

        List<SkillsResponse> skillResponses = new ArrayList<>();

        listOfSkills.forEach(skill -> skillResponses.add(skill.toResponse()));

        return skillResponses;
    }

    public SkillsModel addUserSkill(String skill, Long userId) {
        UserModel user = userService.getUserMiddleware(userId);

        if (user == null)
            return null;

        SkillsModel newSkill = new SkillsModel(skill, user);

        SkillsModel savedSkill = skillsRepository.save(newSkill);

        return savedSkill;
    } 

    public boolean deleteSkill(Long skillId) {
        SkillsModel skill = skillsRepository.findById(skillId).get();

        try {
            skillsRepository.delete(skill);
        } catch (Exception e) {
            return false;
        }

        return true;
    } 
}
