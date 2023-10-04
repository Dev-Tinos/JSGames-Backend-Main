package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GamePostBean {
    @Autowired
    private GameRepository gameRepository;

    public GameDTO exec(GameCreateRequestDTO gameCreateRequestDTO) {
        GameDAO savedGame = gameRepository.save(GameCreateRequestDTO.toDAO(gameCreateRequestDTO));

        return GameDTO.of(savedGame);
    }
}
