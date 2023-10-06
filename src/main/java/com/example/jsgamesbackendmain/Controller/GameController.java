package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import com.example.jsgamesbackendmain.Service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GameController {

    @Autowired
    private GameService gameService;

    // 게임 추가 API
    @Operation(summary = "Post Game")
    @PostMapping("/game")
    public GameDTO postGame(@Valid @RequestBody GameCreateRequestDTO gameCreateRequestDTO) {
        return gameService.postGame(gameCreateRequestDTO);
    }

    // 게임 목록 조회 API
    @Operation(summary = "Get List Game")
    @GetMapping("/games")
    public GameListResponseDTO listGames() {
        return gameService.listGames();
    }

    // 특정 게임 조회 API
    @Operation(summary = "Get Game")
    @GetMapping("/game/{gameId}")
    public GameDTO getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }
}
