package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
