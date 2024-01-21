package com.myproject.hotelmanagementsystem.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
