package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
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
    private UserGetSmallBean userGetSmallBean;

    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public ResultDTO postResult(ResultPostDTO resultPostDTO) {
        // game found
        gameGetSmallBean.getGame(resultPostDTO.getGameId());
        // user found
        userGetSmallBean.getUser(resultPostDTO.getUserId());

        ResultDAO resultDAO = ResultPostDTO.toDAO(resultPostDTO);

        return ResultDTO.of(resultRepository.save(resultDAO));
    }

}
