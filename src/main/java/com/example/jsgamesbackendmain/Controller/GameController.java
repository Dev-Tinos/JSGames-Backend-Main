package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import com.example.jsgamesbackendmain.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;

    // 게임 추가 API
    @PostMapping("/game")
    public GameCreateResponseDTO addGame(@RequestBody GameCreateRequestDTO gameCreateRequestDTO) {
        return  gameService.addGame(gameCreateRequestDTO);
    }

    // 게임 목록 조회 API
    @GetMapping("/games")
    public GameListResponseDTO listGames() {
        return gameService.listGames();
    }

    // 특정 게임 조회 API
    @GetMapping("/game/{gameId}")
    public GameDetailResponseDTO getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }
}
