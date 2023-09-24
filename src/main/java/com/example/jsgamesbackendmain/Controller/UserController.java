package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 특정 유저 조회
    @Operation(summary = "Get User")
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserGetResponseDTO> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Operation(summary = "SignUp User")
    @PostMapping("/user")
    public UserSignUpResponseDTO signUpUser(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) {
        return userService.signUpUser(userSignUpRequestDTO);
    }

    @Operation(summary = "Update User")
    @PutMapping("/user")
    public UserUpdateResponseDTO updateUser(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        return userService.updateUser(userUpdateRequestDTO);
    }


    @Operation(summary = "Delete User")
    @ApiResponse(responseCode = "200", description = "successful operation",
        content = @Content(examples =
            @ExampleObject(value = "{'message': 'Success'}")))
    @DeleteMapping("/user/{userId}")
    public Map<String,String> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
