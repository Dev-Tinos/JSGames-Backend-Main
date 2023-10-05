package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserValidationSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultGetByUserIdBean {
    @Autowired
    private ResultGetByUserIdSmallBean resultGetByUserIdSmallBean;

    @Autowired
    private UserValidationSmallBean userValidationSmallBean;
    public List<ResultGetByUserIdResponseDTO> exec(Long userId, Long page, Long size) {

        //userId 유효성 확인
        userValidationSmallBean.exec(userId);

        return resultGetByUserIdSmallBean.exec(userId, page, size);
    }
}
