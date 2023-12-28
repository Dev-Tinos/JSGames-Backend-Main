package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserGetBean userGetBean;

    private final UserUpdateBean userUpdateBean;

    private final UserDeleteBean userDeleteBean;

    private final UserSignUpBean userSignUpBean;

    private final UserLoginBean userLoginBean;

    public UserGetResponseDTO getUser(String userId) {
        return userGetBean.exec(userId);
    }

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return userUpdateBean.exec(userUpdateRequestDTO);
    }

    public StateResponseDTO deleteUser(String userId) {
        return userDeleteBean.exec(userId);
    }

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        return userSignUpBean.signUpUser(userSignUpRequestDTO);
    }

    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) {
        return userLoginBean.exec(userLoginRequestDTO);
    }
}
