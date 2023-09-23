package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameCreateResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Game1Bean {
    @Autowired
    private GameRepository gameRepository;

    public GameCreateResponseDTO exec(GameCreateRequestDTO gameCreateRequestDTO) {
        GameDAO savedGame = gameRepository.save(GameCreateRequestDTO.toGameDAO(gameCreateRequestDTO));

        return GameCreateResponseDTO.of(savedGame.getGameId(), "SUCCESS", "Game successfully added!");
    }
}
