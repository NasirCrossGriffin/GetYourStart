package com.backend.getyourstart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.getyourstart.models.SynonymModel;

@Repository
public interface SynonymRepository extends JpaRepository<SynonymModel, Long> {
    List<SynonymModel> findByCanonicalWord(String canonicalWord);
    List<SynonymModel> findBySynonym(String synonym);
    boolean existsByCanonicalWordAndSynonym(String canonicalWord, String synonym);
}
