package com.backend.getyourstart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.getyourstart.models.OccupationModel;

@Repository
public interface OccupationRepository extends JpaRepository<OccupationModel, Long> {
    Optional<OccupationModel> findByOccupationName(String occupationName);
    boolean existsByOccupationName(String occupationName);
}
