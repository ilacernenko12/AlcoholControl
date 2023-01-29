package com.example.alcohol.recyclerView;

import java.time.LocalDateTime;

public class Information {
    private LocalDateTime time;
    private String action;
    private String description;

    public Information(LocalDateTime time, String action, String description) {
        this.time = time;
        this.action = action;
        this.description = description;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }
}
