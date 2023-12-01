package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserGetByIdSmallBean {

    @Autowired
    private UserRepository userRepository;

    public UserDAO exec(String userId) {

        Optional<UserDAO> userDAO = userRepository.findById(userId);
        if(!userDAO.isPresent()) {
             throw new ResourceNotFoundException("존재하지 않는 유저입니다.");
        }
        return userDAO.get();
    }
}
