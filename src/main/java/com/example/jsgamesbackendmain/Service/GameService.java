package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.Game1Bean;
import com.example.jsgamesbackendmain.Bean.GameBean.Game2Bean;
import com.example.jsgamesbackendmain.Bean.GameBean.Game3Bean;
import com.example.jsgamesbackendmain.Model.DTO.Game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private Game1Bean game1Bean;
    @Autowired
    private Game2Bean game2Bean;
    @Autowired
    private Game3Bean game3Bean;

    public GameCreateResponseDTO addGame(GameCreateRequestDTO gameCreateRequestDTO) { return game1Bean.exec(gameCreateRequestDTO); }

    public GameListResponseDTO listGames() { return game2Bean.exec(); }

    public GameDetailResponseDTO getGame(Long gameId) { return game3Bean.exec(gameId); }
}
