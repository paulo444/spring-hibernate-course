package com.course.tutorials.Controllers;

import com.course.tutorials.Entities.User;
import com.course.tutorials.Entities.UserErrorResponse;
import com.course.tutorials.Exceptions.UserNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if(userId < 0 || userId >= users.size()){
            throw new UserNotFoundException("UserId: " + userId + " not found.");
        }
        return users.get(userId);
    }

    @DeleteMapping("/user/{userId}")
    public User deleteUserById(@PathVariable int userId){
        if(userId < 0 || userId >= users.size()){
            throw new UserNotFoundException("UserId: " + userId + " not found.");
        }

        return users.remove(userId);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exception)
    {
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setMessage(exception.getMessage());
        userErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        userErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<UserErrorResponse>(userErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleGeneralException(Exception exception){
        UserErrorResponse userErrorResponse = new UserErrorResponse();
        userErrorResponse.setMessage(exception.getMessage());
        userErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        userErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<UserErrorResponse>(userErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
