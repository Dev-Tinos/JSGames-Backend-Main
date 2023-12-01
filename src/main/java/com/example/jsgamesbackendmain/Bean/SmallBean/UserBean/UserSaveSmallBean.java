package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaveSmallBean {
    @Autowired
    private UserRepository userRepository;

    public UserDAO exec(UserDAO userDAO) {
        return userRepository.save(userDAO);
    }
}
