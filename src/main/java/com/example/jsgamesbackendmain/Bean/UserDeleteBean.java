package com.example.jsgamesbackendmain.Bean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDeleteBean {

    @Autowired
    private UserGetBean userGetBean;

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> deleteUser(Long userId) {
        UserDAO user = userGetBean.getUser(userId);
        userRepository.delete(user);
        HashMap<String,String> map = new HashMap<>();
        map.put("message","Success");
        return map;
    }
}
