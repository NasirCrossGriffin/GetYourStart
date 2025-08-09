package com.backend.getyourstart.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.getyourstart.models.SkillsModel;
import com.backend.getyourstart.models.UserModel;

public interface SkillsRepository extends JpaRepository<SkillsModel, Long> {
    @Query("SELECT s FROM SkillsModel s WHERE s.user = :user")
    List<SkillsModel> getSkillsByUser(@Param("user") UserModel user);
}

