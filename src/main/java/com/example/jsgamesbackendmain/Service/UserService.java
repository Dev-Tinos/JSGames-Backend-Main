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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserGetBean userGetBean;

    private final UserUpdateBean userUpdateBean;

    private final UserDeleteBean userDeleteBean;

    private final UserSignUpBean userSignUpBean;

    private final UserLoginBean userLoginBean;

    @Transactional
    public UserGetResponseDTO getUser(String userId) {
        return userGetBean.exec(userId);
    }

    @Transactional
    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return userUpdateBean.exec(userUpdateRequestDTO);
    }

    @Transactional
    public StateResponseDTO deleteUser(String userId) {
        return userDeleteBean.exec(userId);
    }

    @Transactional
    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        return userSignUpBean.signUpUser(userSignUpRequestDTO);
    }

    @Transactional
    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO) {
        return userLoginBean.exec(userLoginRequestDTO);
    }
}
