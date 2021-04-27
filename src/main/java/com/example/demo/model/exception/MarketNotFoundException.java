package com.example.demo.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Market doesn't exist in database")
public class MarketNotFoundException extends RuntimeException {
    public MarketNotFoundException(String message) {
        super(message);
    }

    public MarketNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}