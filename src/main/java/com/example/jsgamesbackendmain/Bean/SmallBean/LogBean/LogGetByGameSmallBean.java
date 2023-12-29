package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;


import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LogGetByGameSmallBean {
    private final LogRepository logRepository;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final GameRepository gameRepository;


    // INFINITE
    public List<LogDAO> exec(GameDAO gameDAO, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<LogDAO> order = null;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                order = logRepository.findByGameOrderByGameScoreDesc(gameDAO, pageable);
                break;
            case GOAL:
                order = logRepository.findByGameOrderByGameScoreWithTargetScore(gameDAO, gameDAO.getTargetScore(), pageable);
                break;
        }

        return order.toList();
    }

    public Long count(GameDAO game) {
        return logRepository.countByGame(game);
    }
}
