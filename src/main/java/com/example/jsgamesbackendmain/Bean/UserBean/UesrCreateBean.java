package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UesrCreateBean {
    @Autowired
    private UserRepository userRepository;

    public UserDAO postUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        UserDAO userDAO = new UserDAO();
        userDAO.setNickname(userSignUpRequestDTO.getNickname());
        userDAO.setEmail(userSignUpRequestDTO.getEmail());
        userDAO.setPassword(userSignUpRequestDTO.getPassword());
        userDAO.setMajor(userSignUpRequestDTO.getMajor());

        return userRepository.save(userDAO);
    }
}
