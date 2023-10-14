package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GameGetPageSmallBean {

    @Autowired
    private GameRepository gameRepository;

    public Page<GameDAO> exec(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }
}
