package com.example.mentorship.entity;

public class Degree {
    private int id;
    private String link;
    private String specialized;

    public Degree(int id, String link, String specialized) {
        this.id = id;
        this.link = link;
        this.specialized = specialized;
    }

    public Degree() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }
}
