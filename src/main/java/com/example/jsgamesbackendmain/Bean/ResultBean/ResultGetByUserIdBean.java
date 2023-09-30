package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultGetByUserIdBean {
    @Autowired
    private ResultGetByUserIdSmallBean resultGetByUserIdSmallBean;

    @Autowired
    private UserGetSmallBean userGetSmallBean;
    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(Long userId) {
        userGetSmallBean.getUser(userId);
        return resultGetByUserIdSmallBean.getResultsByUserId(userId);
    }
}
