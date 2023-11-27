package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailCodeCheckSmallBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UesrCreateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
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
    private EmailCodeCheckSmallBean emailCodeCheckBean;

    @Autowired
    private UesrCreateSmallBean uesrCreateSmallBean;

    @Autowired
    private MapperBean mapperBean;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        // 이메일 중복 확인
        userEmailDuplicateSmallBean.exec(userSignUpRequestDTO.getEmail());
        // 이메일 인증 확인
        emailCodeCheckBean.exec(mapperBean.to(userSignUpRequestDTO, EmailCodeRequestDTO.class));

        return mapperBean.to(uesrCreateSmallBean.exec(userSignUpRequestDTO), UserSignUpResponseDTO.class);
    }
}
