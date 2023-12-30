package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class GameCreateResultDTO {
    private Long gameId;
    private String gameName;
    private String userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;
    private Long viewCount;
    private LocalDateTime createdAt;
    private Double star;

    public static GameCreateResultDTO of(GameDAO gameDAO){
        return GameCreateResultDTO.builder()
                .gameId(gameDAO.getGameId())
                .gameName(gameDAO.getGameName())
                .userId(gameDAO.getUser().getUserId())
                .imageUrl(gameDAO.getGameImage())
                .gameUrl(gameDAO.getGameUrl())
                .targetScore(gameDAO.getTargetScore())
                .scoreType(gameDAO.getScoreType())
                .description(gameDAO.getDescription())
                .viewCount(gameDAO.getViewCount())
                .createdAt(gameDAO.getCreatedAt())
                .star(0.0)
                .build();
    }
}
