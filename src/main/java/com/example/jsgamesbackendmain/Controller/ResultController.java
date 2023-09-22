package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Result.ResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultPostDTO;
import com.example.jsgamesbackendmain.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

//    @GetMapping("/results/game/{gameId}")
//    public ResultDTO getResult(@PathVariable Long gameId) {
//        return resultService.getResult(gameId);
//    }

    @PostMapping("/result")
    public ResultDTO postResult(@RequestBody ResultPostDTO resultPostDTO) {
        return resultService.postResult(resultPostDTO);
    }

}
