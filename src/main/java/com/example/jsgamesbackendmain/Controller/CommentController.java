package com.example.jsgamesbackendmain.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class CommentController {

    @GetMapping("/comment")
    public String getComment() {
        return "Hello, Comment!";
    }
}
