package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserLoginBean {
    @Autowired
    private UserGetByEmailSmallBean userGetByEmailSmallBean;
    @Autowired
    private MapperBean mapperBean;

    public UserLoginResponseDTO exec(UserLoginRequestDTO userLoginRequestDTO){
        UserDAO userDAO = userGetByEmailSmallBean.exec(userLoginRequestDTO.getEmail());

        if(!userDAO.getPassword().equals(userLoginRequestDTO.getPassword())){
            throw new InvalidException("잘못된 비밀번호입니다.");
        }

        return mapperBean.to(userDAO, UserLoginResponseDTO.class);
    }
}
