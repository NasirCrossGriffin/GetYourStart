package com.backend.getyourstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.getyourstart.models.LocationModel;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {
    List<LocationModel> findByCountry(String country);
    List<LocationModel> findByState(String state);
    List<LocationModel> findByCity(String city);
}
