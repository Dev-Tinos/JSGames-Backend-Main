package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserGetByEmailSmallBean {
    private final UserRepository userRepository;

    public UserDAO exec(String email) {
        Optional<UserDAO> userDAO = userRepository.findByEmail(email);
        if (!userDAO.isPresent()) {
            throw new InvalidException("가입되지 않은 이메일입니다.");
        }
        return userDAO.get();
    }
}
