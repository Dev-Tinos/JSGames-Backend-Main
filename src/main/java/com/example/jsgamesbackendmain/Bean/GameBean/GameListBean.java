package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameListBean {
    @Autowired
    private GameRepository gameRepository;

    public GameListResponseDTO exec() {
        List<GameDAO> gameList = gameRepository.findAll();
        List<GameDTO> dtoList = gameList.stream().map(GameDTO::of).collect(Collectors.toList());

        return GameListResponseDTO.of(dtoList);
    }

    public GameListResponseDTO exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        Page<GameDAO> all = gameRepository.findAll(pageRequest);

        List<GameDTO> dtoList = all.toList().stream().map(GameDTO::of).collect(Collectors.toList());

        return GameListResponseDTO.of(dtoList);
    }
}
