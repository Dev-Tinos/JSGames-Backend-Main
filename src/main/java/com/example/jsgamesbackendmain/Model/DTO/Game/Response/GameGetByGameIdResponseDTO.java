package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameGetByGameIdResponseDTO {
    private Long gameId;
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;
    private Long viewCount;

    public static GameGetByGameIdResponseDTO of(GameDAO gameDAO) {
        GameGetByGameIdResponseDTO gameGetByGameIdResponseDTO = new GameGetByGameIdResponseDTO();
        gameGetByGameIdResponseDTO.setGameId(gameDAO.getGameId());
        gameGetByGameIdResponseDTO.setGameName(gameDAO.getGameName());
        gameGetByGameIdResponseDTO.setUserId(gameDAO.getUserId());
        gameGetByGameIdResponseDTO.setImageUrl(gameDAO.getImageUrl());
        gameGetByGameIdResponseDTO.setGameUrl(gameDAO.getGameUrl());
        gameGetByGameIdResponseDTO.setTargetScore(gameDAO.getTargetScore());
        gameGetByGameIdResponseDTO.setScoreType(gameDAO.getScoreType());
        gameGetByGameIdResponseDTO.setDescription(gameDAO.getDescription());
        gameGetByGameIdResponseDTO.setViewCount(gameDAO.getViewCount());

        return gameGetByGameIdResponseDTO;
    }

}

