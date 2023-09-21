package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.UserDTO;
import com.example.jsgamesbackendmain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    // 특정 유저 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDTO>  getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }


    @PostMapping("/user")
    public String postUser() {
        return "Hello, User!";
    }

    @PutMapping("/user")
    public String putUser() {
        return "Hello, User!";
    }


    @DeleteMapping("/user")
    public String deleteUser() {
        return "Hello, User!";
    }
}
