package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UesrPostBean {
    @Autowired
    private UserRepository userRepository;

    public UserDAO postUser(UserSignUpDTO userSignUpDTO) {
        UserDAO userDAO = new UserDAO();
        userDAO.setNickname(userSignUpDTO.getNickname());
        userDAO.setEmail(userSignUpDTO.getEmail());
        userDAO.setPassword(userSignUpDTO.getPassword());
        userDAO.setMajor(userSignUpDTO.getMajor());

        return userRepository.save(userDAO);
    }
}
