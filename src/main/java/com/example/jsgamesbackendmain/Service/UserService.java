package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.*;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
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

    @Autowired
    private UserLoginBean userLoginBean;

    public UserGetResponseDTO getUser(String userId) {
        return userGetBean.getUser(userId);
    }

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return userUpdateBean.updateUser(userUpdateRequestDTO);
    }

    public Map<String,String> deleteUser(String userId) {
        return userDeleteBean.deleteUser(userId);
    }

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        return userSignUpBean.signUpUser(userSignUpRequestDTO);
    }

    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO){
        return userLoginBean.exec(userLoginRequestDTO);
    }
}
