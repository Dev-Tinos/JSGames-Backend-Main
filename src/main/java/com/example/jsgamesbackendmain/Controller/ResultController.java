package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import com.example.jsgamesbackendmain.Service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService resultService;

    //랭킹 조회 API
    @Operation(summary = "특정 게임 유저 랭킹 조회", description =
            "# Game의 result 조회 api  \n\n" +
            "## scoreType이 `INFINITE`인 경우 result 조회시 점수 내림차순  \n\n" +
            "## scoreType이 `GOAL`인 경우 result 조회시 targetScore와 가장 가까운 점수 순서대로 조회"
    )
    @GetMapping("/results/game/{gameId}")
    public List<ResultGetByGameIdResponseDTO> getResultsByGameId(@PathVariable Long gameId, @Parameter Long page, @Parameter Long size) {
        return resultService.getResultsByGameId(gameId, page, size);
    }

//    특정 게임 특정 유저 랭킹 조회 API
    @Operation(summary = "특정 게임 특정 유저의 최고 점수 조회", description =
            "# Game의 특정유저의 최고점수 result 조회 api  \n\n" +
            "## Game의 scoreType이 `INFINITE`인 경우 조회시 가장 높은 점수 조회  \n\n" +
            "## Game의 scoreType이 `GOAL`인 경우 조회시 targetScore와 가장 가까운 점수 조회"
    )
    @GetMapping("/result/game/{gameId}/user/{userId}")
    public ResultGetByGameIdUserIdResponseDTO getResultByGameIdAndUserId(@PathVariable Long gameId, @PathVariable Long userId) {
        return resultService.getResultByGameIdUserId(gameId, userId);
    }

    //게임 결과 저장 API
    @Operation(summary = "랭킹 저장")
    @PostMapping("/result")
    public ResultPostResponseDTO postResult(@RequestBody ResultPostRequestDTO resultPostRequestDTO) {
        return resultService.postResult(resultPostRequestDTO);
    }

    //유저의 게임 결과 로그 조회 API
    @Operation(summary = "UserId로 랭킹 조회", description =
        "# 아직 구현되지 않았음"
    )
    @GetMapping("/results/user/{userId}")
    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(@PathVariable Long userId, @Parameter Long page, @Parameter Long size) {
        return resultService.getResultsByUserId(userId,page, size);
    }
}
