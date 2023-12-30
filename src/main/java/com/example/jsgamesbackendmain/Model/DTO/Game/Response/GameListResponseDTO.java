package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameListResponseDTO {
    private Long gameId;
    private String gameName;
    private String userId;
    private String gameImage;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;
    private Long viewCount;

    public static GameListResponseDTO of(GameDAO gameDAO){
        return GameListResponseDTO.builder()
                .gameId(gameDAO.getGameId())
                .gameName(gameDAO.getGameName())
                .userId(gameDAO.getUser().getUserId())
                .gameImage(gameDAO.getGameImage())
                .gameUrl(gameDAO.getGameUrl())
                .targetScore(gameDAO.getTargetScore())
                .scoreType(gameDAO.getScoreType())
                .description(gameDAO.getDescription())
                .viewCount(gameDAO.getViewCount())
                .build();
    }

    public static List<GameListResponseDTO> listOf(Page<GameDAO> page){
        return page.toList()
                .stream()
                .map(GameListResponseDTO::of)
                .collect(Collectors.toList());
    }
}
