package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.HashBean.HashBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Login {
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;
    private final HashBean hashBean;
    private final TokenService tokenService;

    public UserLoginResponseDTO exec(UserLoginRequestDTO userLoginRequestDTO) {

        // 이메일 검증
        UserDAO userDAO = userGetByEmailSmallBean.exec(userLoginRequestDTO.getEmail());

        // 비밀번호 검증
        if (!hashBean.isMatch(userLoginRequestDTO.getPassword(), userDAO.getPassword())) {
            throw new InvalidException("잘못된 비밀번호입니다.");
        }

        // 토큰 생성
        TokenResponseDTO token = tokenService.createToken(userDAO.getUserId());

        return UserLoginResponseDTO.of(userDAO, token);
    }
}
