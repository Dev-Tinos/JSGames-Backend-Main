package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogValidationSmallBean {
    private final LogRepository logRepository;
    private final UserRepository userRepository;

    public Optional<LogDAO> exec(GameDAO gameDAO, UserDAO userDAO) {

        List<LogDAO> list = logRepository.findByGameAndUser(
                gameDAO, userDAO
                , PageRequest.of(0, 1)
        ).toList();

        Optional<LogDAO> optional = list.stream().findAny();

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Log not found for this GameId And UserId :: " + gameDAO.getGameId() + " And " + userDAO.getUserId());
        } else {
            return optional;
        }
    }
}
