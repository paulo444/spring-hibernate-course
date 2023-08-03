package com.course.tutorials.Controllers;

import com.course.tutorials.Entities.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private Coach coach;

    @Autowired
    public UserController(@Qualifier("swimCoach") Coach coach){
        this.coach = coach;
    }

    @GetMapping("/workout")
    public String getWorkout(){
        return coach.getWorkout();
    }
}
