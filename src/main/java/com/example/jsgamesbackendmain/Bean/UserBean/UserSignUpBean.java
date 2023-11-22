package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailCodeCheckBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserSignUpBean {

    @Autowired
    private UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    @Autowired
    private EmailCodeCheckBean emailCodeCheckBean;

    @Autowired
    private UesrCreateBean uesrCreateBean;

    @Autowired
    private MapperBean mapperBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) throws IOException {
        userEmailDuplicateSmallBean.exec(userSignUpRequestDTO.getEmail());
        emailCodeCheckBean.exec(mapperBean.to(userSignUpRequestDTO, EmailCodeRequestDTO.class));

        return mapperBean.to(uesrCreateBean.postUser(userSignUpRequestDTO), UserSignUpResponseDTO.class);
    }
}
