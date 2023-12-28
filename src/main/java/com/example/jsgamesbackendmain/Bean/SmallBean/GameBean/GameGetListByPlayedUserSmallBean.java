package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GameGetListByPlayedUserSmallBean {
    private final GameRepository gameRepository;
    public List<GameListResponseDTO> exec(String userId, PageRequest pageRequest) {
        return gameRepository.findAllByPlayedUserOrderByViewCountDescGameIdAsc(userId, pageRequest)
                .toList()
                .stream().map(GameListResponseDTO::of)
                .collect(Collectors.toList());
    }
}
