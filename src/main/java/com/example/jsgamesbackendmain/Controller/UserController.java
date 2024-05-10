package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.*;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
//    private final TokenService tokenService;

    // 특정 유저 조회
    @Operation(summary = "UserId로 유저 조회")
    @GetMapping("/user/{userId}")
    public UserGetResponseDTO getByIdUser(@PathVariable String userId) {
        return userService.getByIdUser(userId);
    }

    @Operation(summary = "사용자 검색 목록 조회")
    @GetMapping("/user/search")
    public List<UserSearchByNicknameResponseDTO> getByNameUsers(
            @RequestParam String nickname,
            @RequestParam Integer page,
            @RequestParam Integer size
    ) {
        return userService.getByNameUsers(nickname, page, size);
    }

    @Operation(summary = "유저 회원가입", description = "# 이메일로 받은 코드도 같이 전송해야함 \n" +
            "## 이메일 기입창 -> 회원가입창(안에 코드기입창이 있어야함) \n" +
            "## 유저 사진 스웨거로 불가능 \n" +
            "## 유저 사진 업로드를 하지 않으면 기본 이미지로 설정 \n")
    @PostMapping("/user")
    public UserSignUpResponseDTO signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO) {

        return userService.signUp(userSignUpRequestDTO);
    }

    @Operation(summary = "유저 로그인")
    @PostMapping("/user/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        return userService.login(userLoginRequestDTO);
    }

    @Operation(
            summary = "자동 로그인", description = "## 토큰을 헤더에 넣어서 보내면 됨",
            security = {@SecurityRequirement(name = "accessToken"), @SecurityRequirement(name = "refreshToken")}
    )
    @GetMapping("/user/{userId}/auto/login")
    public UserLoginResponseDTO autoLogin(
            @PathVariable String userId
    ) {
        return userService.autoLogin(userId);
    }


    @Operation(summary = "유저 정보 수정", description = "# userID 제외하면 아무 값도 안들어가도됨 \n" +
            "## 수정할 데이터만 넣으면 그 데이터만 수정")
    @PutMapping("/user")
    public UserUpdateResponseDTO updateUser(@RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
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
