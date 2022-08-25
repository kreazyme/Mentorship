package com.example.mentorship.entity;

import java.io.Serializable;

public class Degree implements Serializable {
    private String id;
    private String link;
    private String specialized;

    public Degree(String id, String link, String specialized) {
        this.id = id;
        this.link = link;
        this.specialized = specialized;
    }

    public Degree() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
