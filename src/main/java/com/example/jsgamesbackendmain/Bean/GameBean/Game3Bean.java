package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDetailResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Game3Bean {
    @Autowired
    private GameGetBean gameGetBean;

    public GameDetailResponseDTO exec(Long gameId) {
        GameDTO gameDTO = gameGetBean.getGame(gameId);
        if (gameDTO == null) {
            throw new ResourceNotFoundException("Game not found for this id :: " + gameId);
        }
        return GameDetailResponseDTO.of(gameDTO, "SUCCESS");
    }
}
