package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailValidation;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserPasswordValidation;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicatesException;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailValidation userEmailValidation;

    @Autowired
    private UserPasswordValidation userPasswordValidation;

    @Autowired
    private UesrPostBean uesrPostBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        boolean emailValid = userEmailValidation.isEmailValid(userSignUpRequestDTO.getEmail());
        if(emailValid){
            throw new DuplicatesException("이미 존재하는 이메일입니다.");
        }
        return UserSignUpResponseDTO.of(uesrPostBean.postUser(userSignUpRequestDTO));
    }
}
