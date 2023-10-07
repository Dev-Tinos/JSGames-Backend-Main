package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GameController {

    @Autowired
    private GameService gameService;

    // 게임 추가 API
    @Operation(summary = "게임 추가", description =
            "# scoreType은 `INFINITE`, `GOAL` 둘 중 하나여야 합니다.  \n" +
            "scoreType이 GOAL인 경우 targetScore는 따로 지정하지 않으면 0입니다."
    )
    @PostMapping("/game")
    public GameDTO postGame(@Valid @RequestBody GameCreateRequestDTO gameCreateRequestDTO) {
        return gameService.postGame(gameCreateRequestDTO);
    }

    // 게임 목록 조회 API
    @Operation(summary = "게임 목록 페이징으로 조회")
    @GetMapping("/games")
    public List<GameListResponseDTO> listGames(@Parameter Long page, @Parameter Long size) {
        return gameService.listGames(page, size);
    }

    // 특정 게임 조회 API
    @Operation(summary = "GameId로 게임 조회")
    @GetMapping("/game/{gameId}")
    public GameGetByGameIdResponseDTO getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }
}
