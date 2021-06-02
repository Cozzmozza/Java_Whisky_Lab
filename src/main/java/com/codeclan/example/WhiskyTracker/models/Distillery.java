package com.codeclan.example.WhiskyTracker.models;

import java.util.ArrayList;
import java.util.List;

public class Distillery {

    private Long id;

    private String name;

    private String region;

    private List<Whisky> whiskies;

    public Distillery(String name, String region) {
        this.name = name;
        this.region = region;
        this.whiskies = new ArrayList<>();
    }

    public Distillery() {
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Whisky> getWhiskies() {
        return whiskies;
    }

    public void setWhiskies(List<Whisky> whiskies) {
        this.whiskies = whiskies;
    }
}
