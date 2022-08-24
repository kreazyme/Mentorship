package com.example.mentorship.Mentor;

import com.example.mentorship.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Mentor implements Serializable {
    private int avatar = R.drawable.mentor_avatar;
    private String name = "";
    private String job = "";
    private String phoneNum = "";
    private String email = "";
    private String workPlace = "";
    private int numOfMentor = 0;
    private int numOfMentee = 0;
    private int numOfFollowers = 0;
    private int numOfHourMent = 0;
    private float rate = (float) 4.9;
    private String introduction = "";
    private ArrayList<MentorActivity> mentorActivities = new ArrayList<>();
    private ArrayList<String> experienceList = new ArrayList<>(Arrays.asList(
            "4 năm làm việc với Backend tại MDC Software",
            "2 năm kinh nghiệm làm việc với Android"
    ));
    private ArrayList<String> studyList = new ArrayList<>(Arrays.asList(
            "Tốt nghiệp kĩ sư ngành Kỹ thuật máy tính tại Đại học Bách Khoa Hà Nội",
            "Đã học tại Trung học Phổ thông chuyên Đại học Vinh"
    ));
    private ArrayList<String> skillList = new ArrayList<>(Arrays.asList(
            "Giao tiếp Tiếng Anh",
            "Nấu ăn"
    ));
    private ArrayList<String> degreeList = new ArrayList<>(Arrays.asList(
            "SQL Advance of Hackerrank"
    ));
    private ArrayList<String> awardList = new ArrayList<>(Arrays.asList(
            "Giải ba Olympic Toán học sinh, sinh viên"
    ));
    public Mentor(int avatar, String name, String job, String workPlace,int numOfMentor, int numOfMentee, int numOfFollowers, float rate, String introduction, ArrayList<MentorActivity> mentorActivities,int x) {
        this.avatar = avatar;
        this.name = name;
        this.job = job;
        this.workPlace = workPlace;
        this.numOfMentee = numOfMentee;
        this.numOfMentor = numOfMentor;
        this.numOfFollowers = numOfFollowers;
        this.rate = rate;
        this.introduction = introduction;
        this.mentorActivities = mentorActivities;
        this.numOfHourMent = x;
    }

    public Mentor(int avatar, String name, String job, String workPlace, int numOfMentee, int numOfFollowers, int numOfHourMent, float rate, String introduction, ArrayList<MentorActivity> mentorActivities, ArrayList<String> experienceList, ArrayList<String> studyList, ArrayList<String> skillList, ArrayList<String> degreeList, ArrayList<String> awardList) {
        this.avatar = avatar;
        this.name = name;
        this.job = job;
        this.workPlace = workPlace;
        this.numOfMentee = numOfMentee;
        this.numOfFollowers = numOfFollowers;
        this.numOfHourMent = numOfHourMent;
        this.rate = rate;
        this.introduction = introduction;
        this.mentorActivities = mentorActivities;
        this.experienceList = experienceList;
        this.studyList = studyList;
        this.skillList = skillList;
        this.degreeList = degreeList;
        this.awardList = awardList;
    }

    public Mentor(int avatar, String name, String job, String phoneNum, String email, String workPlace, int numOfMentor, int numOfMentee, int numOfFollowers, int numOfHourMent, float rate, String introduction, ArrayList<MentorActivity> mentorActivities, ArrayList<String> experienceList, ArrayList<String> studyList, ArrayList<String> skillList, ArrayList<String> degreeList, ArrayList<String> awardList) {
        this.avatar = avatar;
        this.name = name;
        this.job = job;
        this.phoneNum = phoneNum;
        this.email = email;
        this.workPlace = workPlace;
        this.numOfMentor = numOfMentor;
        this.numOfMentee = numOfMentee;
        this.numOfFollowers = numOfFollowers;
        this.numOfHourMent = numOfHourMent;
        this.rate = rate;
        this.introduction = introduction;
        this.mentorActivities = mentorActivities;
        this.experienceList = experienceList;
        this.studyList = studyList;
        this.skillList = skillList;
        this.degreeList = degreeList;
        this.awardList = awardList;
    }

    public Mentor() {

    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getNumOfMentor() {
        return numOfMentor;
    }

    public void setNumOfMentor(int numOfMentor) {
        this.numOfMentor = numOfMentor;
    }

    public ArrayList<String> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<String> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<String> getStudyList() {
        return studyList;
    }

    public void setStudyList(ArrayList<String> studyList) {
        this.studyList = studyList;
    }

    public ArrayList<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<String> skillList) {
        this.skillList = skillList;
    }

    public ArrayList<String> getDegreeList() {
        return degreeList;
    }

    public void setDegreeList(ArrayList<String> degreeList) {
        this.degreeList = degreeList;
    }

    public ArrayList<String> getAwardList() {
        return awardList;
    }

    public void setAwardList(ArrayList<String> awardList) {
        this.awardList = awardList;
    }
}
