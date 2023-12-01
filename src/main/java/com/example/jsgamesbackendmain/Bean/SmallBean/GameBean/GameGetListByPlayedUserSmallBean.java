package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameGetListByPlayedUserSmallBean {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private MapperBean mapperBean;

    public List<GameListResponseDTO> exec(String userId, PageRequest pageRequest) {
        List<GameDAO> list = gameRepository.findAllByPlayedUserOrderByViewCountDescGameIdAsc(userId, pageRequest)
                .toList();

        return list.stream().map(game -> mapperBean.to(game, GameListResponseDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }
}
