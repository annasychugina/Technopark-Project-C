package com.example.ekkert.myapplication.models;

import java.util.List;

/**
 * Created by admin on 03.05.2016.
 */
public class City {

    private long id;
    private String name;
    private String info;
    private String url;
    private String email;
    private List<Attraction> attractions;

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public City(long id, String name, String info, String url, String email) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.url = url;
        this.email = email;
    }

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
