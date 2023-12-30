package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankByMajorGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankMajorGetResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Service.RankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class RankController {
    private final RankService rankService;

    // 전체 Game의 Top100 유저 조회
    @Operation(summary = "Top100 유저 랭크 조회", description =
            "# Top100 테이블에 있는 유저들을 조회합니다. \n" +
                    "### 각 Game마다 1~100등까지 결과들에 점수를 매겨 전체 게임 유저 랭킹을 조회 \n" +
                    "- 게임마다 100등부터 51등까지는 (50명)  \n" +
                    "    (100등)1점~(51등)50점  \n" +
                    "- 게임마다 50등부터 11등까지 5의 배수로 증가 (40명)  \n" +
                    "    (50등)55점~ (11등)250점  \n" +
                    "- 게임마다 10등 부터 1등까지 20의 배수로 증가 (10명)  \n" +
                    "    (10등)270점 ~ (1등)450점"
    )
    @GetMapping("/rank/users")
    public RankGetResponseDTO getRank(@RequestParam Integer page, @RequestParam Integer size) {
        return rankService.rankGet(page, size);
    }

    @Operation(summary = "학과내 랭킹 조회")
    @GetMapping("/rank/major")
    public RankByMajorGetResponseDTO getRankMajor(@RequestParam Major major) {
        return rankService.rankGetByMajor(major);
    }

    @Operation(summary = "학과별 랭킹 조회")
    @GetMapping("/major")
    public RankMajorGetResponseDTO getMajor() {
        return rankService.getRankMajor();
    }
}
