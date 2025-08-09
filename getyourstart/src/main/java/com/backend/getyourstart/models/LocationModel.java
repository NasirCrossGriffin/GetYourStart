package com.backend.getyourstart.models;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class LocationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    public LocationModel() {
    }

    public LocationModel(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
