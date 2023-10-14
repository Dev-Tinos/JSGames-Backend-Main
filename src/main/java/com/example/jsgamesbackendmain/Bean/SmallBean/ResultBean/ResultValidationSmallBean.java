package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResultValidationSmallBean {
    @Autowired
    private ResultRepository resultRepository;
    public Optional<ResultDAO> exec(GameDAO gameDAO, Long userId) {
        Optional<ResultDAO> optional = Optional.empty();
        switch (gameDAO.getScoreType()) {
            case INFINITE:
                optional = resultRepository.findFirstByGameIdAndUserIdOrderByGameScoreDesc(gameDAO.getGameId(), userId);
                break;
            case GOAL:
                List<ResultDAO> list = resultRepository.findFirstByGameIdAndUserIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(), userId, gameDAO.getTargetScore(), PageRequest.of(0, 1));
                if (list.isEmpty()) {
                    optional = Optional.empty();
                } else
                    optional = Optional.of(list.get(0));
                break;
        }

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Result not found for this GameId And UserId :: " + gameDAO.getGameId() + " And " + gameDAO.getUserId());
        } else {
            return optional;
        }
    }
}
