package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameCreateBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameCreateBean game1Bean;
    @Autowired
    private GameListBean game2Bean;
    @Autowired
    private GameGetBean game3Bean;

    public GameDTO createGame(GameCreateRequestDTO gameCreateRequestDTO) { return game1Bean.exec(gameCreateRequestDTO); }

    public GameListResponseDTO listGames() { return game2Bean.exec(); }

    public GameDTO getGame(Long gameId) { return game3Bean.exec(gameId); }
}
