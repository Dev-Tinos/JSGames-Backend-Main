package com.example.jsgamesbackendmain.Model.DTO.Game;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateRequestDTO {
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private Long targetScore;
    private ScoreType scoreType;
    private String description;

    public static GameDAO toDAO(GameCreateRequestDTO dto) {
        GameDAO gameDAO = new GameDAO();
        gameDAO.setGameName(dto.getGameName());
        gameDAO.setUserId(dto.getUserId());
        gameDAO.setImageUrl(dto.getImageUrl());
        gameDAO.setGameUrl(dto.getGameUrl());
        gameDAO.setTargetScore(dto.getTargetScore());
        gameDAO.setScoreType(dto.getScoreType());
        gameDAO.setDescription(dto.getDescription());
        return gameDAO;
    }
}
