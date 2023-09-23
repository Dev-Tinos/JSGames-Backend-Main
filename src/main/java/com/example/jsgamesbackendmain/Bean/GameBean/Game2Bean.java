package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Game2Bean {
    @Autowired
    private GameRepository gameRepository;

    public GameListResponseDTO exec() {
        List<GameDAO> gameList = gameRepository.findAll();
        List<GameDTO> dtoList = gameList.stream().map(GameDTO::of).collect(Collectors.toList());

        return GameListResponseDTO.of(dtoList, "SUCCESS");
    }
}
