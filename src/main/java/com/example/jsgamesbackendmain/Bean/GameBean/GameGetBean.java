package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameGetBean {
    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public GameDTO exec(Long gameId) {
        return GameDTO.of(gameGetSmallBean.exec(gameId));
    }
}
