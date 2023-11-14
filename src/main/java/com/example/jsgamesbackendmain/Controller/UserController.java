package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.*;
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

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // 특정 유저 조회
    @Operation(summary = "UserId로 유저 조회")
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserGetResponseDTO> getUser(@PathVariable Long userId) {
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
    public Map<String, String> deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    // 전체 Game의 Top100 유저 조회
    @Operation(summary = "Top100 유저 조회", description =
            "# Top100 테이블에 있는 유저들을 조회합니다. \n" +
            "### 각 Game마다 1~100등까지 결과들에 점수를 매겨 전체 게임 유저 랭킹을 조회 \n" +
            "- 게임마다 100등부터 51등까지는 (50명)  \n" +
            "    (100등)1점~(51등)50점  \n" +
            "- 게임마다 50등부터 11등까지 5의 배수로 증가 (40명)  \n" +
            "    (50등)55점~ (11등)250점  \n" +
            "- 게임마다 10등 부터 1등까지 20의 배수로 증가 (10명)  \n" +
            "    (10등)270점 ~ (1등)450점"
    )
    @GetMapping("/users/top100")
    public List<UserGetTop100ResponseDTO> getTop100Users(@RequestParam Long page, @RequestParam Long size) {
        return userService.getTop100User(page, size);
    }

    @Operation(summary = "Top100 테이블에 유저 세팅 (여러번 금지)", description =
            "# 여러번금지! (서버 과부하 걸릴수도)  \n" +
            "## 또한 자동으로 오후 11시 50분 마다 자동으로 실행됨  \n" +
            "### 각 Game마다 1~100등까지 결과들에 점수를 매겨 전체 게임 유저 랭킹을 조회 \n" +
            "- 게임마다 100등부터 51등까지는 (50명)  \n" +
            "    (100등)1점~(51등)50점  \n" +
            "- 게임마다 50등부터 11등까지 5의 배수로 증가 (40명)  \n" +
            "    (50등)55점~ (11등)250점  \n" +
            "- 게임마다 10등 부터 1등까지 20의 배수로 증가 (10명)  \n" +
            "    (10등)270점 ~ (1등)450점"
    )
    @ApiResponse(responseCode = "200", description = "successful operation",
            content = @Content(examples =
            @ExampleObject(value = "{'result': 'success'}")))
    @PostMapping("/users/top100/set")
    public Map<String,String> setTop100Users() {
        return userService.setTop100User();
    }
}
