package com.course.tutorials.Exceptions;

import com.course.tutorials.Entities.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
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
