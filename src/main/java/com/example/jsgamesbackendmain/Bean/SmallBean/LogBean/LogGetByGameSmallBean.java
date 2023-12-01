package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;


import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogGetByGameSmallBean {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private UserGetByIdSmallBean userGetByIdSmallBean;
    @Autowired
    private MapperBean mapperBean;


    // INFINITE
    public List<LogGetByGameIdResponseDTO> exec(GameDAO gameDAO, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<LogDAO> order = null;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                order = logRepository.findByGameIdOrderByGameScoreDesc(gameDAO.getGameId(), pageable);
                break;
            case GOAL:
                order = logRepository.findByGameIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(),gameDAO.getTargetScore(), pageable);
                break;
        }

        return order.toList().stream().map(logDAO -> {
            LogGetByGameIdResponseDTO dto = mapperBean.to(logDAO, LogGetByGameIdResponseDTO.class);
            dto.setUser(mapperBean.to(userGetByIdSmallBean.exec(logDAO.getUserId()), UserLogResponseDTO.class));
            return dto;
        }).collect(Collectors.toList());
    }

    public Long count(Long gameId) {
        return logRepository.countByGameId(gameId);
    }
}
