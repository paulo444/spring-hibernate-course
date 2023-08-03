package com.course.tutorials.Configurations;

import com.course.tutorials.Entities.Coach;
import com.course.tutorials.Entities.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoachConfig {
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
