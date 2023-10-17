package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class InvalidException extends RuntimeException {
    public InvalidException(String message) {
        super(message);
    }
}