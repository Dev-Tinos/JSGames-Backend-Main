package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLoginResponseDTO;
import com.example.jsgamesbackendmain.Service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AutoLogin {
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    private final TokenService tokenService;

    public UserLoginResponseDTO exec(String userId) {
        // 유저 정보 가져오기
        UserDAO userDAO = userGetByIdSmallBean.exec(userId);

        // 토큰 생성
        // 만약 AccessToken이 만료되었다면 RefreshToken을 이용하여 AccessToken을 재발급
        // 만약 RefreshToken이 만료되었다면 에러를 발생시킴
        TokenResponseDTO token = tokenService.autoLogin(userDAO.getUserId());

        return UserLoginResponseDTO.of(userDAO, token);
    }
}
