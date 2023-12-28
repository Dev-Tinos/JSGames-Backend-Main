package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
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

    public List<GameListResponseDTO> exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        return gameRepository.findAllByOrderByViewCountDescGameIdAsc(pageRequest).toList()
                .stream()
                .map(GameListResponseDTO::of)
                .collect(Collectors.toList());
    }

    public List<GameListResponseDTO> exec(Long userId, Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        return gameRepository.findAllByOrderByViewCountDescGameIdAsc(pageRequest)
                .toList()
                .stream()
                .map(GameListResponseDTO::of)
                .collect(Collectors.toList());
    }
}
