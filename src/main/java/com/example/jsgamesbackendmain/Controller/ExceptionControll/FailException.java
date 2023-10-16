package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class FailException extends RuntimeException {
    public FailException(String message) {
        super(message);
    }
}