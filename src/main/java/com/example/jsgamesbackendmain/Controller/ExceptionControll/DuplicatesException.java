package com.example.jsgamesbackendmain.Controller.ExceptionControll;

public class DuplicatesException extends RuntimeException {
    public DuplicatesException(String message) {
        super(message);
    }
}
