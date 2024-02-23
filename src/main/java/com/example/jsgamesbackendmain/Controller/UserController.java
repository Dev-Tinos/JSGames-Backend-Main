package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Service.TokenService;
import com.example.jsgamesbackendmain.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    // 특정 유저 조회
    @Operation(summary = "UserId로 유저 조회")
    @GetMapping("/user/{userId}")
    public UserGetResponseDTO getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @Operation(summary = "유저 회원가입", description = "# 이메일로 받은 코드도 같이 전송해야함 \n" +
            "## 이메일 기입창 -> 회원가입창(안에 코드기입창이 있어야함) \n" +
            "## 유저 사진 스웨거로 불가능 \n" +
            "## 유저 사진 업로드를 하지 않으면 기본 이미지로 설정 \n")
    @PostMapping("/user")
    public UserSignUpResponseDTO signUpUser(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) throws IOException {

        return userService.signUpUser(userSignUpRequestDTO);
    }

    @Operation(summary = "유저 로그인")
    @PostMapping("/user/login")
    public UserLoginResponseDTO loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        return userService.loginUser(userLoginRequestDTO);
    }

    @Operation(
            summary = "자동 로그인", description = "## 토큰을 헤더에 넣어서 보내면 됨",
            security = {@SecurityRequirement(name = "accessToken"), @SecurityRequirement(name = "refreshToken")}
    )
    @GetMapping("/user/{userId}/auto/login")
    public UserLoginResponseDTO autoLoginUser(
            @PathVariable String userId
    ) {
        return userService.autoLoginUser(userId);
    }


    @Operation(summary = "유저 정보 수정", description = "# userID 제외하면 아무 값도 안들어가도됨 \n" +
            "## 수정할 데이터만 넣으면 그 데이터만 수정")
    @PutMapping("/user")
    public UserUpdateResponseDTO updateUser(@ModelAttribute UserUpdateRequestDTO userUpdateRequestDTO) {
        return userService.updateUser(userUpdateRequestDTO);
    }

    @Operation(summary = "유저 삭제")
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(examples =
            @ExampleObject(value = "{'message': 'Success'}")))
    @DeleteMapping("/user/{userId}")
    public StateResponseDTO deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }
}
