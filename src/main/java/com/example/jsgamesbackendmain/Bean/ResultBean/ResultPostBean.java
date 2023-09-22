package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultPostDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultPostBean {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserGetBean userGetBean;

    @Autowired
    private GameGetBean gameGetBean;

    public ResultDTO postResult(ResultPostDTO resultPostDTO) {
        // game found
        gameGetBean.getGame(resultPostDTO.getGameId());
        // user found
        userGetBean.getUser(resultPostDTO.getUserId());

        ResultDAO resultDAO = ResultPostDTO.toDAO(resultPostDTO);

        return ResultDTO.of(resultRepository.save(resultDAO));
    }

}
