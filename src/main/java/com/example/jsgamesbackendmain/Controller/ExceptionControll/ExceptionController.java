package com.example.jsgamesbackendmain.Controller.ExceptionControll;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        return ResponseEntity.status(404).body(map);
    }
}
