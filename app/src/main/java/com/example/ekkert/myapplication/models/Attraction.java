package com.example.ekkert.myapplication.models;

/**
 * Created by admin on 03.05.2016.
 */
public class Attraction {

    private long id;
    private String name;
    private String note;

    public Attraction(long id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public Attraction() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

