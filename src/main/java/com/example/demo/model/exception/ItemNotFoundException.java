package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item doesn't exist in database")
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
