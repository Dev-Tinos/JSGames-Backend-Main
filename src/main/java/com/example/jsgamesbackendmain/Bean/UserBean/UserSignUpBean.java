package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailValidationSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserPasswordValidationSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicatesException;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailValidationSmallBean userEmailValidationSmallBean;

    @Autowired
    private UesrCreateBean uesrCreateBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        boolean emailValid = userEmailValidationSmallBean.isEmailValid(userSignUpRequestDTO.getEmail());
        if(emailValid){
            throw new DuplicatesException("이미 존재하는 이메일입니다.");
        }
        return UserSignUpResponseDTO.of(uesrCreateBean.postUser(userSignUpRequestDTO));
    }
}
