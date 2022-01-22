package com.example.nitaxcodingchallenge.exception;

public class ApiResourceNotFoundException extends RuntimeException{
    public ApiResourceNotFoundException(String message) {
        super(message);
    }
}
