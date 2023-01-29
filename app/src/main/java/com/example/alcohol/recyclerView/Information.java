package com.example.alcohol.recyclerView;

public class Information {
    private String time;
    private String action;
    private String description;

    public Information(String time, String action, String description) {
        this.time = time;
        this.action = action;
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }
}
