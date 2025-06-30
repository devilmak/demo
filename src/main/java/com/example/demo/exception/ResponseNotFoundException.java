package com.example.demo.exception;

public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException(String message) {
        super(message);
    }
}
