package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import com.example.jsgamesbackendmain.Repository.UserTop100Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGetTop100Bean {

    @Autowired
    private UserTop100Repository userTop100Repository;
    public List<UserTop100DAO> exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());
        return userTop100Repository.findAllByOrderByScoreDesc(pageRequest).toList();
    }
}
