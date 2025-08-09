package com.backend.getyourstart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "synonyms")
public class SynonymModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "canonical_word", nullable = false, length = 255)
    private String canonicalWord;

    @Column(name = "synonym", nullable = false, length = 255)
    private String synonym;

    public SynonymModel() {
    }

    public SynonymModel(String canonicalWord, String synonym) {
        this.canonicalWord = canonicalWord;
        this.synonym = synonym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCanonicalWord() {
        return canonicalWord;
    }

    public void setCanonicalWord(String canonicalWord) {
        this.canonicalWord = canonicalWord;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
}
