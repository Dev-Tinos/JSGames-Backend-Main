package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ResultGetByGameIdUserIdSmallBean {
    @Autowired
    private ResultValidationSmallBean resultValidationSmallBean;

    public ResultDAO exec(GameDAO gameDAO, Long userId) {

        Optional<ResultDAO> optional = resultValidationSmallBean.exec(gameDAO, userId);
        return optional.get();
    }
}
