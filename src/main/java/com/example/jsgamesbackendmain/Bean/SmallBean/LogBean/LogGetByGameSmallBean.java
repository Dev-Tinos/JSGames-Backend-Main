package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;


import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
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


    // INFINITE
    public List<LogGetByGameIdResponseDTO> exec(GameDAO gameDAO, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<LogDAO> order = null;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                order = logRepository.findByGameOrderByGameScoreDesc(gameDAO.getGameId(), pageable);
                break;
            case GOAL:
                order = logRepository.findByGameIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(), gameDAO.getTargetScore(), pageable);
                break;
        }

        return order.toList().stream().map(logDAO ->
                LogGetByGameIdResponseDTO.of(
                        logDAO,
                        userGetByIdSmallBean.exec(logDAO.getUser().getUserId())
                )
        ).collect(Collectors.toList());
    }

    public Long count(Long gameId) {
        return logRepository.countByGame(gameId);
    }
}
