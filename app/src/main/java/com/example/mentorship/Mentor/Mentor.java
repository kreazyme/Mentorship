package com.example.mentorship.Mentor;

public class Mentor {
    private int avatar;
    private String name;
    private String job;
    private String workPlace;
    private int numOfMentee;
    private int numOfFollowers;

    public Mentor(int avatar, String name, String job, String workPlace, int numOfMentee, int numOfFollowers) {
        this.avatar = avatar;
        this.name = name;
        this.job = job;
        this.workPlace = workPlace;
        this.numOfMentee = numOfMentee;
        this.numOfFollowers = numOfFollowers;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getNumOfMentee() {
        return numOfMentee;
    }

    public void setNumOfMentee(int numOfMentee) {
        this.numOfMentee = numOfMentee;
    }

    public int getNumOfFollowers() {
        return numOfFollowers;
    }

    public void setNumOfFollowers(int numOfFollowers) {
        this.numOfFollowers = numOfFollowers;
    }
}
