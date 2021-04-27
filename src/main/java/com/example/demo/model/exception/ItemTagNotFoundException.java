package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item tag doesn't exist in database")
public class ItemTagNotFoundException extends RuntimeException{
    public ItemTagNotFoundException(String message) {
        super(message);
    }

    public ItemTagNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
