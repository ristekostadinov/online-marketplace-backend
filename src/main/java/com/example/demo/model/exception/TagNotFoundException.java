package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Tag doesn't exist in database")
public class TagNotFoundException extends RuntimeException{
    public TagNotFoundException(String message) {
        super(message);
    }
    public TagNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
