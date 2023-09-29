package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    @Autowired
    private UesrCreateBean uesrCreateBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        userEmailDuplicateSmallBean.isEmailExist(userSignUpRequestDTO.getEmail());

        return UserSignUpResponseDTO.of(uesrCreateBean.postUser(userSignUpRequestDTO));
    }
}
