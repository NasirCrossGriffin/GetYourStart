package com.backend.getyourstart.dto;

public class SkillsResponse {
    private String skill;
    private Long userId;

    public SkillsResponse() {
    }

    public SkillsResponse(String skill, Long userId) {
        this.skill = skill;
        this.userId = userId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
