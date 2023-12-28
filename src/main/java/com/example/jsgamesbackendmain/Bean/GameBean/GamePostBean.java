package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GamePostBean {
    private final GameRepository gameRepository;
    public GameDTO exec(GameCreateRequestDTO gameCreateRequestDTO) {
        return GameDTO.of(gameRepository.save(gameCreateRequestDTO.toDAO()));
    }
}
