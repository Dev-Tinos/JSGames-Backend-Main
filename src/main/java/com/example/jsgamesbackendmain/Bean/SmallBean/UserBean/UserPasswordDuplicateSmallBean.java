package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPasswordDuplicateSmallBean {
    private final UserRepository userRepository;


    public boolean isPasswordValid(String password) {
        Optional<UserDAO> optional = userRepository.findByPassword(password);
        return optional.isPresent();
    }
}
