package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

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
    private Double star;

    public static GameGetByGameIdResponseDTO of(GameDAO gameDAO, Double star){
        return GameGetByGameIdResponseDTO.builder()
                .gameId(gameDAO.getGameId())
                .gameName(gameDAO.getGameName())
                .userId(gameDAO.getUserId())
                .imageUrl(gameDAO.getGameImage())
                .gameUrl(gameDAO.getGameUrl())
                .targetScore(gameDAO.getTargetScore())
                .scoreType(gameDAO.getScoreType())
                .description(gameDAO.getDescription())
                .viewCount(gameDAO.getViewCount())
                .star(star)
                .build();
    }
}

