package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GamePostBean {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private MapperBean mapperBean;

    public GameDTO exec(GameCreateRequestDTO gameCreateRequestDTO) {
        GameDAO savedGame = gameRepository.save(mapperBean.to(gameCreateRequestDTO, GameDAO.class));

        return GameDTO.of(savedGame);
    }
}
