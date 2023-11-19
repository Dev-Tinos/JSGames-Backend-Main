package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import com.example.jsgamesbackendmain.Service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LogController {

    @Autowired
    private LogService logService;

    //랭킹 조회 API
    @Operation(summary = "특정 게임 유저 순위 조회", description =
            "# Game의 Log 조회 api  \n\n" +
            "## scoreType이 `INFINITE`인 경우 Log 조회시 점수 내림차순  \n\n" +
            "## scoreType이 `GOAL`인 경우 Log 조회시 targetScore와 가장 가까운 점수 순서대로 조회"
    )
    @GetMapping("/logs/game/{gameId}")
    public List<LogGetByGameIdResponseDTO> getLogsByGameId(@PathVariable Long gameId, @Parameter Integer page, @Parameter Integer size) {
        return logService.getLogsByGameId(gameId, page, size);
    }

//    특정 게임 특정 유저 랭킹 조회 API
    @Operation(summary = "특정 게임 특정 유저의 최고 점수 조회", description =
            "# Game의 특정유저의 최고점수 Log 조회 api  \n\n" +
            "## Game의 scoreType이 `INFINITE`인 경우 조회시 가장 높은 점수 조회  \n\n" +
            "## Game의 scoreType이 `GOAL`인 경우 조회시 targetScore와 가장 가까운 점수 조회"
    )
    @GetMapping("/log/game/{gameId}/user/{userId}")
    public LogGetByGameIdUserIdResponseDTO getLogByGameIdAndUserId(@PathVariable Long gameId, @PathVariable String userId) {
        return logService.getLogByGameIdUserId(gameId, userId);
    }

    //게임 결과 저장 API
    @Operation(summary = "랭킹 저장")
    @PostMapping("/log")
    public LogPostResponseDTO postLog(@RequestBody LogPostRequestDTO logPostRequestDTO) {
        return logService.postLog(logPostRequestDTO);
    }

    //유저의 게임 결과 로그 조회 API
//    @Operation(summary = "UserId로 Log 조회", description =
//        "# 특정 게임의 모든 user log 내림차순 조회"
//    )
//    @GetMapping("/logs/user/{userId}")
//    public List<LogGetByUserIdResponseDTO> getLogsByUserId(@PathVariable String userId, @Parameter Long page, @Parameter Long size) {
//        return logService.getLogsByUserId(userId,page, size);
//    }
}
