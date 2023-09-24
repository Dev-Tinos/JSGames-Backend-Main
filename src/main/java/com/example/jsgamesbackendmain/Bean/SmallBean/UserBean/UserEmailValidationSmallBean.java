package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserEmailValidationSmallBean {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailValid(String email) {
        Optional<UserDAO> optional = userRepository.findByEmail(email);
        return optional.isPresent();
    }

}
