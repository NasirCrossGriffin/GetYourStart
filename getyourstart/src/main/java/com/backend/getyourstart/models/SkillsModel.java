package com.backend.getyourstart.models;

import java.util.Objects;

import com.backend.getyourstart.dto.SkillsResponse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class SkillsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "skill", nullable = false, length = 255)
    private String skill;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public SkillsModel() {
    }

    public SkillsModel(String skill, UserModel user) {
        this.skill = skill;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public SkillsModel skill(String skill) {
        setSkill(skill);
        return this;
    }

    public SkillsModel user(UserModel user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SkillsModel)) {
            return false;
        }
        SkillsModel skillsModel = (SkillsModel) o;
        return Objects.equals(id, skillsModel.id) &&
               Objects.equals(skill, skillsModel.skill) &&
               Objects.equals(user, skillsModel.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", skill='" + getSkill() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

    public SkillsResponse toResponse() {
        Long userId = (this.user != null) ? this.user.getId() : null; 
        return new SkillsResponse(this.skill, userId);
    }
}
