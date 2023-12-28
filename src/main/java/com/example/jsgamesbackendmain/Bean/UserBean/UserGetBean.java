package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserGetBean {
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public UserGetResponseDTO exec(String userId) {
        return UserGetResponseDTO.of(userGetByIdSmallBean.exec(userId));
    }
}
