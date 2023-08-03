package com.course.tutorials.Entities;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getWorkout() {
        return "Hittttttt!";
    }
}
