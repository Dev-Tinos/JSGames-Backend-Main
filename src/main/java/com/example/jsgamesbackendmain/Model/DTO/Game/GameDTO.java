package com.example.jsgamesbackendmain.Model.DTO.Game;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameDTO {

    private Long gameId;
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private String description;

        public static GameDTO of(GameDAO gameDAO) {
            GameDTO gameDTO = new GameDTO();
            gameDTO.setGameId(gameDAO.getGameId());
            gameDTO.setGameName(gameDAO.getGameName());
            gameDTO.setUserId(gameDAO.getUserId());
            gameDTO.setImageUrl(gameDAO.getImageUrl());
            gameDTO.setGameUrl(gameDAO.getGameUrl());
            gameDTO.setDescription(gameDAO.getDescription());

            return gameDTO;
        }
}
