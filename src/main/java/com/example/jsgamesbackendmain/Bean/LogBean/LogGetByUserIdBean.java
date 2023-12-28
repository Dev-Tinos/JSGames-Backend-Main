package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogGetByUserIdBean {
    private final LogGetByUserIdSmallBean logGetByUserIdSmallBean;

    private final UserGetByIdSmallBean userValidationSmallBean;

    public List<LogGetByUserIdResponseDTO> exec(String userId, Long page, Long size) {

        //userId 유효성 확인
        UserDAO user = userValidationSmallBean.exec(userId);

        return logGetByUserIdSmallBean.exec(user, page, size);
    }
}
