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
    public Optional<LogDAO> exec(GameDAO gameDAO, String userId) {

        List<LogDAO> list = logRepository.findByGameIdAndUserId(
                gameDAO.getGameId(), userId
                ,PageRequest.of(0,1)
        ).toList();

        Optional<LogDAO> optional = list.stream().findAny();

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Log not found for this GameId And UserId :: " + gameDAO.getGameId() + " And " + userId);
        } else {
            return optional;
        }
    }
}
