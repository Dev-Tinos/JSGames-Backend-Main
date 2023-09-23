package com.example.jsgamesbackendmain.Model.DTO.Game;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateRequestDTO {
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private String description;

    public static GameDAO toGameDAO(GameCreateRequestDTO dto) {
        GameDAO gameDAO = new GameDAO();
        gameDAO.setGameName(dto.getGameName());
        gameDAO.setUserId(dto.getUserId());
        gameDAO.setImageUrl(dto.getImageUrl());
        gameDAO.setGameUrl(dto.getGameUrl());
        gameDAO.setDescription(dto.getDescription());
        return gameDAO;
    }
}