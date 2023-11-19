package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserGetSmallBean {
    @Autowired
    private UserValidationSmallBean userValidationSmallBean;

    public UserDAO getUser(String userId) {

        Optional<UserDAO> optional = userValidationSmallBean.exec(userId);

        return optional.get();
    }
}

