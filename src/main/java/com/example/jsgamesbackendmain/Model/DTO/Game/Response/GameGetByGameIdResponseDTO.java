package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameGetByGameIdResponseDTO {
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

    public static GameGetByGameIdResponseDTO of(GameDAO gameDAO, Double star){
        return GameGetByGameIdResponseDTO.builder()
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
                .star(star)
                .build();
    }
}

