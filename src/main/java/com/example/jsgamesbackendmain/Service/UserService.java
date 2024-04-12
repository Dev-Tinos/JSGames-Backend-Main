package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.*;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final GetUserByUserId getUserByUserId;

    private final GetUsersByName getUsersByName;

    private final UpdateUser updateUser;

    private final DeleteUser deleteUser;

    private final SignUp signUp;

    private final Login login;

    private final AutoLogin autoLogin;

    @Transactional
    public UserGetResponseDTO getByIdUser(String userId) {
        return getUserByUserId.exec(userId);
    }

    @Transactional
    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return updateUser.exec(userUpdateRequestDTO);
    }

    @Transactional
    public StateResponseDTO deleteUser(String userId) {
        return deleteUser.exec(userId);
    }

    @Transactional
    public UserSignUpResponseDTO signUp(UserSignUpRequestDTO userSignUpRequestDTO) {
        return signUp.exec(userSignUpRequestDTO);
    }

    @Transactional
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        return login.exec(userLoginRequestDTO);
    }

    @Transactional
    public UserLoginResponseDTO autoLogin(String userId) {
        return autoLogin.exec(userId);
    }

    @Transactional
    public List<UserSearchByNicknameResponseDTO> getByNameUsers(String nickname, Integer page, Integer size) {
        return getUsersByName.exec(nickname, page, size);
    }
}
