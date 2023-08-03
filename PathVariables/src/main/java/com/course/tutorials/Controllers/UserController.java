package com.course.tutorials.Controllers;

import com.course.tutorials.Entities.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    List<User> users;

    @PostConstruct
    public void initializeUsers(){
        users = new ArrayList<User>();

        users.add(new User("User1", 10));
        users.add(new User("User2", 20));
        users.add(new User("User3", 30));
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return users;
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId){
        return users.get(userId);
    }

    @DeleteMapping("/user/{userId}")
    public User deleteUserById(@PathVariable int userId){
        return users.remove(userId);
    }
}
