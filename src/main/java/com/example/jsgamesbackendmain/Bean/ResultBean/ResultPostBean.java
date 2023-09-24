package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultPostBean {
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private UserGetSmallBean userGetSmallBean;

    @Autowired
    private GameGetBean gameGetBean;

    public ResultPostResponseDTO postResult(ResultPostRequestDTO resultPostRequestDTO) {
        // game found
        gameGetBean.getGame(resultPostRequestDTO.getGameId());
        // user found
        userGetSmallBean.getUser(resultPostRequestDTO.getUserId());

        ResultDAO resultDAO = resultPostRequestDTO.toDAO();

        return ResultPostResponseDTO.of(resultRepository.save(resultDAO));
    }

}
