package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

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
                .userId(gameDAO.getUserId())
                .gameImage(gameDAO.getGameImage())
                .gameUrl(gameDAO.getGameUrl())
                .targetScore(gameDAO.getTargetScore())
                .scoreType(gameDAO.getScoreType())
                .description(gameDAO.getDescription())
                .viewCount(gameDAO.getViewCount())
                .build();
    }
}
