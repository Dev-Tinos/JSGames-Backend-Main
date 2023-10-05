package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;


import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultGetByGameIdSmallBean {
    @Autowired
    private ResultRepository resultRepository;


    // INFINITE
    public List<ResultGetByGameIdResponseDTO> exec(GameDAO gameDAO, Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue());

        Page<ResultDAO> order = null;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                order = resultRepository.findByGameIdOrderByGameScoreDesc(gameDAO.getGameId(), pageable);
                break;
            case GOAL:
                order = resultRepository.findByGameIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(),gameDAO.getTargetScore(), pageable);
                break;
        }

        List<ResultDAO> results = order.toList();

        return results.stream().map(ResultGetByGameIdResponseDTO::of).collect(Collectors.toList());
    }
}
