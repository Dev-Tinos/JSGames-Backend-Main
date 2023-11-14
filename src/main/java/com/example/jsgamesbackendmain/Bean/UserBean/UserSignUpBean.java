package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailCodeCheckBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    @Autowired
    private EmailCodeCheckBean emailCodeCheckBean;

    @Autowired
    private UesrCreateBean uesrCreateBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        userEmailDuplicateSmallBean.exec(userSignUpRequestDTO.getEmail());

        EmailCodeRequestDTO emailCodeRequestDTO = new EmailCodeRequestDTO();
        emailCodeRequestDTO.setEmail(userSignUpRequestDTO.getEmail());
        emailCodeRequestDTO.setCode(userSignUpRequestDTO.getCode());
        emailCodeCheckBean.exec(emailCodeRequestDTO);

        return UserSignUpResponseDTO.of(uesrCreateBean.postUser(userSignUpRequestDTO));
    }
}
