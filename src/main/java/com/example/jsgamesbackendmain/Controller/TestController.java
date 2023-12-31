package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Service.TestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(name = "Test", description = "테스트용 API")
public class TestController {

    private final TestService testService;

    @Operation(summary = "이메일 코드 테이블 데이터 삭제", description =
            "## 또한 자동으로 오후 11시 55분 마다 자동으로 실행됨"
    )
    @PostMapping("/email/clear")
    public String emailClear(){
        return testService.emailClear();
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
    @PostMapping("/users/rank/set")
    public StateResponseDTO setTop100Users() {
        return testService.setRank();
    }

    @Operation(summary = "전공의 따른 랭킹 세팅 (여러번 금지)", description =
            "# 여러번금지! (서버 과부하 걸릴수도)  \n" +
                    "## 또한 자동으로 오후 11시 55분 마다 자동으로 실행됨  \n" +
                    "### 각 Game마다 1~100등까지 결과들에 점수를 매겨 전체 게임 유저 랭킹을 조회 \n" +
                    "- 게임마다 100등부터 51등까지는 (50명)  \n" +
                    "    (100등)1점~(51등)50점  \n" +
                    "- 게임마다 50등부터 11등까지 5의 배수로 증가 (40명)  \n" +
                    "    (50등)55점~ (11등)250점  \n" +
                    "- 게임마다 10등 부터 1등까지 20의 배수로 증가 (10명)  \n" +
                    "    (10등)270점 ~ (1등)450점"
    )
    @PostMapping("/users/rank/set/major")
    public StateResponseDTO setMajor() {
        return testService.setMajor();
    }

    @Operation(summary = "이미지 초기화")
    @PostMapping("/image/set")
    public StateResponseDTO setImage() {
        return testService.setImage();
    }
}
