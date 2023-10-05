package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserValidationSmallBean;
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
    private UserValidationSmallBean userValidationSmallBean;

    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public ResultPostResponseDTO postResult(ResultPostRequestDTO resultPostRequestDTO) {
        // game found
        gameGetSmallBean.exec(resultPostRequestDTO.getGameId());

        // user found
        userValidationSmallBean.exec(resultPostRequestDTO.getUserId());

        ResultDAO resultDAO = resultPostRequestDTO.toDAO();

        return ResultPostResponseDTO.of(resultRepository.save(resultDAO));
    }

}
