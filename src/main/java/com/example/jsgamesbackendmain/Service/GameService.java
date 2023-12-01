package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameGetListByPlayedUser;
import com.example.jsgamesbackendmain.Bean.GameBean.GamePostBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GamePostBean gamePostBean;
    @Autowired
    private GameGetBean gameGetBean;
    @Autowired
    private GameGetListByPlayedUser gameGetListByPlayedUser;


    public GameDTO postGame(GameCreateRequestDTO gameCreateRequestDTO) {
        return gamePostBean.exec(gameCreateRequestDTO);
    }

    public GameGetByGameIdResponseDTO getGame(Long gameId) {
        return gameGetBean.exec(gameId);
    }

    public List<GameListResponseDTO> listGamesByUser(String userId, Long page, Long size) {
        return gameGetListByPlayedUser.exec(userId, page, size);
    }
}
