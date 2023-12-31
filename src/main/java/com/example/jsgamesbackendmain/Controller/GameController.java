package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameCreateResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.GameSort;
import com.example.jsgamesbackendmain.Service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class GameController {

    private final GameService gameService;

    // 게임 추가 API
    @Operation(summary = "게임 추가", description =
            "# scoreType은 `INFINITE`, `GOAL` 둘 중 하나여야 합니다.  \n" +
            "scoreType이 GOAL인 경우 targetScore는 따로 지정하지 않으면 0입니다."
    )
    @PostMapping("/game")
    public GameCreateResultDTO postGame(@Valid @RequestBody GameCreateRequestDTO gameCreateRequestDTO) {
        return gameService.postGame(gameCreateRequestDTO);
    }

    // 게임 목록 조회 API
    @Operation(summary = "게임 목록 조회 (페이징) ", description =
            "# 게임 목록 조회  \n" +
                    "## 기본은 조회수 순으로 내림차순 정렬됩니다." +
                    "### 지원되는 정렬 옵션은 `VIEW_COUNT`, `PLAYED_USER`, `RECENT`, `REVIEW_COUNT`, `RANDOM` 입니다.  \n" +
                    "### 또한 모든 정렬은 내림차순으로 정렬됩니다." +
                    "정렬 옵션은 `sort` query string으로 전달해주세요.  \n" +
                    "VIEW_COUNT: 조회수 높은 순  \n" +
                    "PLAYED_USER: 플레이한 유저 많은 순  \n" +
                    "RECENT: 최신순  \n" +
                    "REVIEW_COUNT: 리뷰 많은 순"
    )
    @GetMapping("/games")
    public List<GameListResponseDTO> listGames(
            @RequestParam @Min(0) Integer page,
            @RequestParam @Min(0) @Max(10) Integer size,
            @RequestParam(defaultValue = "VIEW_COUNT")GameSort sort
            ) {
        return gameService.listGames(page, size, sort);
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
    public List<GameListResponseDTO> listGamesByUser(
            @PathVariable String userId,
            @Parameter @Min(0) Integer page,
            @Parameter @Min(0) @Max(10) Integer size
    ) {
        return gameService.listGamesByUser(userId, page, size);
    }
}
