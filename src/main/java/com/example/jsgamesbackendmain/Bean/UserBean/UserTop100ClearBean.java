package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Repository.UserTop100Repository;
import com.example.jsgamesbackendmain.Repository.UserWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTop100ClearBean {
    @Autowired
    private UserTop100Repository userTop100Repository;
    @Autowired
    private UserWeightRepository userWeightRepository;

    public void exec() {
        // UserTop100DAO를 모두 삭제
        userTop100Repository.deleteAll();

        // UserWeightDAO를 모두 삭제
        userWeightRepository.deleteAll();
    }
}
