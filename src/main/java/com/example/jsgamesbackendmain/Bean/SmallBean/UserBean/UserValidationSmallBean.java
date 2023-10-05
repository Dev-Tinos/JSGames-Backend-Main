package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidationSmallBean {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDAO> exec(Long userId) {

        Optional<UserDAO> optional = userRepository.findById(userId);
        if(!optional.isPresent()) {
             throw new ResourceNotFoundException("User not found for this id :: " + userId);
        }
        return optional;
    }
}
