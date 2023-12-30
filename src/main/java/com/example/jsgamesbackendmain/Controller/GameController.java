package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class GameController {

    private final GameService gameService;

    // 게임 추가 API
    @Operation(summary = "게임 추가", description =
            "# scoreType은 `INFINITE`, `GOAL` 둘 중 하나여야 합니다.  \n" +
            "scoreType이 GOAL인 경우 targetScore는 따로 지정하지 않으면 0입니다."
    )
    @PostMapping("/game")
    public GameDTO postGame(@Valid @RequestBody GameCreateRequestDTO gameCreateRequestDTO) {
        return gameService.postGame(gameCreateRequestDTO);
    }

    // 특정 게임 조회 API
    @Operation(summary = "GameId로 게임 조회", description =
        "# GameId로 게임 조회시 조회수가 1 증가합니다."
    )
    @GetMapping("/game/{gameId}")
    public GameGetByGameIdResponseDTO getGame(@PathVariable Long gameId) {
        return gameService.getGame(gameId);
    }

    @Operation(summary = "특정 유저의 플레이한 게임 리스트 조회", description =
            "# 특정 유저의 플레이한 게임 리스트 조회"
    )
    @GetMapping("/game/user/{userId}")
    public List<GameListResponseDTO> listGamesByUser(@PathVariable String userId, @Parameter Integer page, @Parameter Integer size) {
        return gameService.listGamesByUser(userId, page, size);
    }
}
