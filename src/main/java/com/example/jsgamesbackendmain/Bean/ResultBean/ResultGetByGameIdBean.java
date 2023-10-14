package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultGetByGameIdBean {
    @Autowired
    private ResultGetByGameIdSmallBean resultGetByGameIdSmallBean;

    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public List<ResultDAO> exec(Long gameId, Long page, Long size) {

        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        return resultGetByGameIdSmallBean.exec(gameDAO, page, size);
    }

}
