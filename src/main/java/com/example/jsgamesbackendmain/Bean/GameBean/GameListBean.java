package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GameListBean {
    @Autowired
    private GameRepository gameRepository;

    public List<GameListResponseDTO> exec() {
        List<GameDAO> gameList = gameRepository.findAll();
        List<GameListResponseDTO> list = gameList.stream().map(GameListResponseDTO::of).collect(Collectors.toList());

        return list;
    }

    public List<GameListResponseDTO> exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        Page<GameDAO> all = gameRepository.findAllByOrderByViewCountDesc(pageRequest);

        List<GameListResponseDTO> list = all.toList().stream().map(GameListResponseDTO::of).collect(Collectors.toList());

        return list;
    }
}
