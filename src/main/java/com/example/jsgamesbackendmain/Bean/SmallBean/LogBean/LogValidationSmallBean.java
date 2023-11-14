package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LogValidationSmallBean {
    @Autowired
    private LogRepository logRepository;
    public Optional<LogDAO> exec(GameDAO gameDAO, Long userId) {
        Optional<LogDAO> optional = Optional.empty();
        switch (gameDAO.getScoreType()) {
            case INFINITE:
                optional = logRepository.findFirstByGameIdAndUserIdOrderByGameScoreDesc(gameDAO.getGameId(), userId);
                break;
            case GOAL:
                List<LogDAO> list = logRepository.findFirstByGameIdAndUserIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(), userId, gameDAO.getTargetScore(), PageRequest.of(0, 1));
                if (list.isEmpty()) {
                    optional = Optional.empty();
                } else
                    optional = Optional.of(list.get(0));
                break;
        }

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Log not found for this GameId And UserId :: " + gameDAO.getGameId() + " And " + gameDAO.getUserId());
        } else {
            return optional;
        }
    }
}
