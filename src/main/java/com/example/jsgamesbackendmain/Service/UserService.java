package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserDeleteBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserSignUpBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserUpdateRequestDTO;
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

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return userUpdateBean.updateUser(userUpdateRequestDTO);
    }

    public Map<String,String> deleteUser(Long userId) {
        return userDeleteBean.deleteUser(userId);
    }

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpDTO) {
        return userSignUpBean.signUpUser(userSignUpDTO);
    }
}
