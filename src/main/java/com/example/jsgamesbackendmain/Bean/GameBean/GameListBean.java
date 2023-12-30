package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GameListBean {
    private final GameRepository gameRepository;

    public List<GameListResponseDTO> exec() {
        return gameRepository.findAll()
                .stream()
                .map(GameListResponseDTO::of)
                .collect(Collectors.toList());
    }

    public List<GameListResponseDTO> exec(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return GameListResponseDTO.listOf(gameRepository.findAllByOrderByViewCountDescGameIdAsc(pageRequest));
    }

    public List<GameListResponseDTO> exec(Long userId, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return GameListResponseDTO.listOf(gameRepository.findAllByOrderByViewCountDescGameIdAsc(pageRequest));
    }
}
