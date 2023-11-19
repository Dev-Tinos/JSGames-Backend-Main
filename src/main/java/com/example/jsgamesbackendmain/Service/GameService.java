package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GamePostBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GamePostBean gamePostBean;
    @Autowired
    private GameGetBean gameGetBean;

    public GameDTO postGame(GameCreateRequestDTO gameCreateRequestDTO) { return gamePostBean.exec(gameCreateRequestDTO); }

    public GameGetByGameIdResponseDTO getGame(Long gameId) { return gameGetBean.exec(gameId); }
}
