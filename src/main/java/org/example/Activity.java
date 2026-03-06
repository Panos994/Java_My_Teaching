package org.example;

import java.time.LocalTime;

public class Activity {

    private int startTime;
    private int endTime;

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}
