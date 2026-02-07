package com.sudheesh.example.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a Hard 5K";
    }
}
