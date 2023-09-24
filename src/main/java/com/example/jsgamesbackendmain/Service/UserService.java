package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserDeleteBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserSignUpBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserGetBean userGetBean;

    @Autowired
    private UserUpdateBean userUpdateBean;

    @Autowired
    private UserDeleteBean userDeleteBean;

    @Autowired
    private UserSignUpBean userSignUpBean;

    public UserGetResponseDTO getUser(Long userId) {
        return UserGetResponseDTO.of(userGetBean.getUser(userId));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        return userUpdateBean.updateUser(userDTO);
    }

    public Map<String,String> deleteUser(Long userId) {
        return userDeleteBean.deleteUser(userId);
    }

    public UserDTO signUpUser(UserSignUpDTO userSignUpDTO) {
        return userSignUpBean.signUpUser(userSignUpDTO);
    }
}
