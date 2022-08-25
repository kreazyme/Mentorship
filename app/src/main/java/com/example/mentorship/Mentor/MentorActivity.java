package com.example.mentorship.Mentor;

public class MentorActivity {
    private int activityPicture;
    private String activity;
    private String language;

    public MentorActivity(int activityPicture, String activity, String language) {
        this.activityPicture = activityPicture;
        this.activity = activity;
        this.language = language;
    }

    public MentorActivity() {
    }

    public int getActivityPicture() {
        return activityPicture;
    }

    public void setActivityPicture(int activityPicture) {
        this.activityPicture = activityPicture;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
