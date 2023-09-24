package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}
