package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // 특정 유저 조회
    @Operation(summary = "UserId로 유저 조회")
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserGetResponseDTO> getUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Operation(summary = "유저 회원가입", description = "# 이메일로 받은 코드도 같이 전송해야함" +
            "## 이메일 기입창 -> 회원가입창(안에 코드기입창이 있어야함)")
    @PostMapping("/user")
    public UserSignUpResponseDTO signUpUser(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) {
        return userService.signUpUser(userSignUpRequestDTO);
    }

    @Operation(summary = "유저 로그인")
    @PostMapping("/user/login")
    public UserLoginResponseDTO loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        return userService.loginUser(userLoginRequestDTO);
    }

    @Operation(summary = "유저 정보 수정")
    @PutMapping("/user")
    public UserUpdateResponseDTO updateUser(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        return userService.updateUser(userUpdateRequestDTO);
    }

    @Operation(summary = "유저 삭제")
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(examples =
            @ExampleObject(value = "{'message': 'Success'}")))
    @DeleteMapping("/user/{userId}")
    public Map<String, String> deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
