package com.example.jsgamesbackendmain.Controller.ExceptionControll;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> resourceNotFoundException(ResourceNotFoundException e) {
        return exceptionHandler(e);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Map<String, String>> duplicatesException(DuplicateException e) {
        return exceptionHandler(e);
    }

    private ResponseEntity<Map<String, String>> exceptionHandler(Exception e) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        return ResponseEntity.status(404).body(map);
    }
}
