package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Bean.HashBean.HashBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class UserCreateSmallBean {
    private final UserSaveSmallBean userSaveSmallBean;
    private final MajorMapperBean majorMapperBean;
    private final HashBean hashBean;

    public UserDAO exec(UserSignUpRequestDTO userSignUpRequestDTO) {
        //ParentMajor set
        ParentMajor parentMajor = majorMapperBean.getParentMajor(userSignUpRequestDTO.getMajor());

        // 현재 시간 + 이메일 해시
        String userId = HashBean.createHash((new Date().getTime()) + userSignUpRequestDTO.getEmail());

        // 비밀번호 해싱
        String password = hashBean.encrypt(userSignUpRequestDTO.getPassword());

        UserDAO user = userSignUpRequestDTO.toDAO(userId, password, parentMajor);

        return userSaveSmallBean.exec(user);
    }
}
