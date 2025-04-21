package com.backend.getyourstart.repository;
import com.backend.getyourstart.models.JSearchJobModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JSearchJobRepository extends JpaRepository<JSearchJobModel, Long> {
    
}
