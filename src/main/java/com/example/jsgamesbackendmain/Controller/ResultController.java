package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import com.example.jsgamesbackendmain.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/results/game/{gameId}")
    public List<ResultGetResponseDTO> getResult(@PathVariable Long gameId) {
        return resultService.getResultByGameId(gameId);
    }

    @PostMapping("/result")
    public ResultPostResponseDTO postResult(@RequestBody ResultPostRequestDTO resultPostRequestDTO) {
        return resultService.postResult(resultPostRequestDTO);
    }

}
