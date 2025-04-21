package com.backend.getyourstart.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.getyourstart.models.AdzunaJobModel;
import com.backend.getyourstart.models.UserModel;

public interface AdzunaJobRepository extends JpaRepository<AdzunaJobModel, Long> {
    @Query("SELECT j FROM AdzunaJobModel j WHERE j.user = :user")
    List<AdzunaJobModel> getAdzunaJobsByUser(@Param("user") UserModel user);
}
