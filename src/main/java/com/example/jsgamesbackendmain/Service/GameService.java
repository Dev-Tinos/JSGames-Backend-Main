package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GamePostBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GamePostBean gamePostBean;
    @Autowired
    private GameListBean gameListBean;
    @Autowired
    private GameGetBean gameGetBean;

    public GameDTO postGame(GameCreateRequestDTO gameCreateRequestDTO) { return gamePostBean.exec(gameCreateRequestDTO); }

    public GameListResponseDTO listGames(Long page,Long size) { return gameListBean.exec(page, size); }

    public GameDTO getGame(Long gameId) { return gameGetBean.exec(gameId); }
}
