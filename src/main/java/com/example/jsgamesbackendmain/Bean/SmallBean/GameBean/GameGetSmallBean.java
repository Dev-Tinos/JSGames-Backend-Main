package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GameGetSmallBean {
    @Autowired
    private GameRepository gameRepository;

    public GameDTO getGame(Long gameId) {
        Optional<GameDAO> optional = gameRepository.findById(gameId);
        if(!optional.isPresent()) {
            throw new RuntimeException("Game not found for this id :: " + gameId);
        }
        return GameDTO.of(optional.get());
    }
}
