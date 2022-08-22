package com.example.mentorship.Mentor;

import com.example.mentorship.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Mentor implements Serializable {
    private int avatar = R.drawable.mentor_avatar;
    private String name = "";
    private String job = "";
    private String workPlace = "";
    private int numOfMentee = 0;
    private int numOfFollowers = 0;
    private int numOfHourMent = 0;
    private float rate = (float) 4.9;
    private String introduction = "";
    private ArrayList<MentorActivity> mentorActivities = new ArrayList<>();

    public Mentor(int avatar, String name, String job, String workPlace, int numOfMentee, int numOfFollowers, float rate, String introduction, ArrayList<MentorActivity> mentorActivities,int x) {
        this.avatar = avatar;
        this.name = name;
        this.job = job;
        this.workPlace = workPlace;
        this.numOfMentee = numOfMentee;
        this.numOfFollowers = numOfFollowers;
        this.rate = rate;
        this.introduction = introduction;
        this.mentorActivities = mentorActivities;
        this.numOfHourMent = x;
    }

    public Mentor() {

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

    public int getNumOfHourMent() {
        return numOfHourMent;
    }

    public void setNumOfHourMent(int numOfHourMent) {
        this.numOfHourMent = numOfHourMent;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public ArrayList<MentorActivity> getMentorActivities() {
        return mentorActivities;
    }

    public void setMentorActivities(ArrayList<MentorActivity> mentorActivities) {
        this.mentorActivities = mentorActivities;
    }

}
