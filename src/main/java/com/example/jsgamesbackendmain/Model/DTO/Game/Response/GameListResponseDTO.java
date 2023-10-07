package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameListResponseDTO {
    private Long gameId;
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;
    private Long viewCount;

    public static GameListResponseDTO of(GameDAO gameDAO) {
        GameListResponseDTO gameListResponseDTO = new GameListResponseDTO();
        gameListResponseDTO.setGameId(gameDAO.getGameId());
        gameListResponseDTO.setGameName(gameDAO.getGameName());
        gameListResponseDTO.setUserId(gameDAO.getUserId());
        gameListResponseDTO.setImageUrl(gameDAO.getImageUrl());
        gameListResponseDTO.setGameUrl(gameDAO.getGameUrl());
        gameListResponseDTO.setTargetScore(gameDAO.getTargetScore());
        gameListResponseDTO.setScoreType(gameDAO.getScoreType());
        gameListResponseDTO.setDescription(gameDAO.getDescription());
        gameListResponseDTO.setViewCount(gameDAO.getViewCount());

        return gameListResponseDTO;
    }
}
