package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import com.example.jsgamesbackendmain.Service.ResultService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

    //랭킹 조회 API
    @GetMapping("/results/game/{gameId}")
    public List<ResultGetResponseDTO> getResultsByGameId(@PathVariable Long gameId, @Parameter Long page, @Parameter Long size) {
        return resultService.getResultsByGameId(gameId, page, size);
    }

    //게임 결과 저장 API
    @PostMapping("/result")
    public ResultPostResponseDTO postResult(@RequestBody ResultPostRequestDTO resultPostRequestDTO) {
        return resultService.postResult(resultPostRequestDTO);
    }

    //유저의 게임 결과 로그 조회 API
    @GetMapping("/results/user/{userId}")
    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(@PathVariable Long userId) {
        return resultService.getResultsByUserId(userId);
    }
}
