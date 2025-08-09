package com.backend.getyourstart.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.getyourstart.models.SavedGYSJobModel;
import com.backend.getyourstart.models.UserModel;

public interface GYSJobRepository extends JpaRepository<SavedGYSJobModel, Long> {
    @Query("SELECT j FROM SavedGYSJobModel j WHERE j.user = :user")
    List<SavedGYSJobModel> getGYSJobsByUser(@Param("user") UserModel user);
    
    @Query("SELECT j FROM SavedGYSJobModel j WHERE j.id = :id")
    Optional<SavedGYSJobModel> getGYSJobById(@Param("id") Long id);
}