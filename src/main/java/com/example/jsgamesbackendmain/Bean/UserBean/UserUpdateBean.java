package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGetBean userGetBean;

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        UserDAO user = userGetBean.getUser(userUpdateRequestDTO.getUserId());
        user.setNickname(userUpdateRequestDTO.getNickname());
        user.setEmail(userUpdateRequestDTO.getEmail());
        user.setPassword(userUpdateRequestDTO.getPassword());
        user.setMajor(userUpdateRequestDTO.getMajor());
        return UserUpdateResponseDTO.of(userRepository.save(user));
    }
}
