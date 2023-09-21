package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserPasswordValidation {
    @Autowired
    private UserRepository userRepository;


    public boolean isPasswordValid(String password) {
        Optional<UserDAO> optional = userRepository.findByPassword(password);
        return optional.isPresent();
    }
}
