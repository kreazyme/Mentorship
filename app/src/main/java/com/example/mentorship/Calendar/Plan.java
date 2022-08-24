package com.example.mentorship.Calendar;

public class Plan {
    private String time_start;
    private String time_end;
    private String activity;

    public Plan(String time_start, String time_end, String activity) {
        this.time_start = time_start;
        this.time_end = time_end;
        this.activity = activity;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
