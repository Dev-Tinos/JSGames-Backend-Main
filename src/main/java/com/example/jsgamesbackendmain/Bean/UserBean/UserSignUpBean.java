package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailValidation;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UesrCreateBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserPasswordValidation;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicatesException;
import com.example.jsgamesbackendmain.Model.DTO.User.UserDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.UserSignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailValidation userEmailValidation;

    @Autowired
    private UserPasswordValidation userPasswordValidation;

    @Autowired
    private UesrCreateBean uesrCreateBean;

    public UserDTO signUpUser(UserSignUpDTO userSignUpDTO) {
        boolean emailValid = userEmailValidation.isEmailValid(userSignUpDTO.getEmail());
        if(emailValid){
            throw new DuplicatesException("이미 존재하는 이메일입니다.");
        }
        return UserDTO.of(uesrCreateBean.createUser(userSignUpDTO));
    }
}
