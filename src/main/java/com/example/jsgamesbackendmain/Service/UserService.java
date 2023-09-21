package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserGetBean;
import com.example.jsgamesbackendmain.Bean.UserDeleteBean;
import com.example.jsgamesbackendmain.Bean.UserUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserGetBean userGetBean;

    @Autowired
    private UserUpdateBean userUpdateBean;

    public UserDTO getUser(Long userId) {
        return UserDTO.of(userGetBean.getUser(userId));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return userUpdateBean.updateUser(userDTO);
    }
}
