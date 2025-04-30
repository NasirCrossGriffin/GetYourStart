package com.backend.getyourstart.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.backend.getyourstart.models.JSearchJobModel;
import com.backend.getyourstart.models.UserModel;

public interface JSearchJobRepository extends JpaRepository<JSearchJobModel, Long> {
    @Query("SELECT j FROM JSearchJobModel j WHERE j.user = :user")
    List<JSearchJobModel> getJSearchJobsByUser(@Param("user") UserModel user);

    @Query("SELECT j FROM JSearchJobModel j WHERE j.id = :id")
    Optional<JSearchJobModel> getJSearchJobById(@Param("id") Long id);
}
