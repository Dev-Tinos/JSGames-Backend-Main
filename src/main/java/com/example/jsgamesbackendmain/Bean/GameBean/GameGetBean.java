package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameGetBean {
    @Autowired
    private GameGetSmallBean gameGetBean;

    public GameDTO exec(Long gameId) {
        GameDTO gameDTO = gameGetBean.getGame(gameId);
        if (gameDTO == null) {
            throw new ResourceNotFoundException("Game not found for this id :: " + gameId);
        }
        return gameDTO;
    }
}
