package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserLoginBean {
    @Autowired
    private UserRepository userRepository;

    public UserLoginResponseDTO exec(UserLoginRequestDTO userLoginRequestDTO){
        Optional<UserDAO> userDAO = userRepository.findByEmail(userLoginRequestDTO.getEmail());

        if(!userDAO.isPresent()){
            throw new InvalidException("가입되지 않은 이메일입니다.");
        }

        if(!userDAO.get().getPassword().equals(userLoginRequestDTO.getPassword())){
            throw new InvalidException("잘못된 비밀번호입니다.");
        }

        return  UserLoginResponseDTO.of(userDAO.get());
    }
}
