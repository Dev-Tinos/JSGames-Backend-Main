package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailCodeCheckSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserCreateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSignUpBean {

    private final UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    private final EmailCodeCheckSmallBean emailCodeCheckBean;

    private final UserCreateSmallBean userCreateSmallBean;

    private final TokenService tokenService;

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        // 이메일 중복 확인
        userEmailDuplicateSmallBean.exec(userSignUpRequestDTO.getEmail());
        // 이메일 인증 확인
        emailCodeCheckBean.exec(EmailCodeRequestDTO.of(userSignUpRequestDTO));

        // 유저 생성
        UserDAO newUser = userCreateSmallBean.exec(userSignUpRequestDTO);

        // 토큰 생성
        TokenResponseDTO token = tokenService.createToken(newUser.getUserId());

        return UserSignUpResponseDTO.of(newUser, token);
    }
}
