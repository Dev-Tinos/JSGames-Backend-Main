package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserValidationSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
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

    public List<LogGetByUserIdResponseDTO> exec(String userId, Long page, Long size) {

        //userId 유효성 확인
        UserDAO user = userValidationSmallBean.exec(userId).get();

        return logGetByUserIdSmallBean.exec(user, page, size);
    }
}
