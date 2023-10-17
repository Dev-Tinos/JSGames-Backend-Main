package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class ExceededException extends RuntimeException {
    public ExceededException(String message) {
        super(message);
    }
}