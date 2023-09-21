package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGetBean userGetBean;

    public UserDTO updateUser(UserDTO userDTO) {
        UserDAO user = userGetBean.getUser(userDTO.getUserId());
        user.setNickname(userDTO.getNickname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setMajor(userDTO.getMajor());
        return UserDTO.of(userRepository.save(user));
    }
}
