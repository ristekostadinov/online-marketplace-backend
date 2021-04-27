package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Subscriber doesn't exist in database")
public class SubscriberNotFoundException extends RuntimeException{
    public SubscriberNotFoundException(String message){
        super(message);
    }

    public SubscriberNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
