package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserValidationSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogGetByUserIdBean {
    @Autowired
    private LogGetByUserIdSmallBean logGetByUserIdSmallBean;

    @Autowired
    private UserValidationSmallBean userValidationSmallBean;
    public List<LogGetByUserIdResponseDTO> exec(Long userId, Long page, Long size) {

        //userId 유효성 확인
        userValidationSmallBean.exec(userId);

        return logGetByUserIdSmallBean.exec(userId, page, size);
    }
}