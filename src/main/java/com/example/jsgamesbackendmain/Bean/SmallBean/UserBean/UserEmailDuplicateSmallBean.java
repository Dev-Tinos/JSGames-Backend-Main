package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserEmailDuplicateSmallBean {

    @Autowired
    private UserRepository userRepository;

    //이메일 중복 검사
    public void exec(String email) {
        Optional<UserDAO> optional = userRepository.findByEmail(email);
        if(optional.isPresent()){
            throw new DuplicateException("이미 존재하는 이메일입니다.");
        }
    }
}
