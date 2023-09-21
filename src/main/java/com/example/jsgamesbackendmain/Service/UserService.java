package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Model.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.jsgamesbackendmain.Bean.UserGetBean;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserGetBean userGetBean;

    public UserDTO getUser(Long userId) {
        return userGetBean.getUser(userId);
    }
}
