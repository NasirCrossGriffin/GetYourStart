package com.backend.getyourstart.dto;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

      private List<String> area;
      private String display_name;


    public List<String> getArea() {
        return this.area;
    }

    public void setArea(List<String> area) {
        this.area = area;
    }

    public String getDisplay_name() {
        return this.display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

}
