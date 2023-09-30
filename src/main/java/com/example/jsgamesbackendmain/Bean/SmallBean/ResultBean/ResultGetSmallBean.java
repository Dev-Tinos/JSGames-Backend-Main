package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetResponseDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultGetSmallBean {

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultGetResponseDTO> getResultsByGameId(Long gameId) {

        List<ResultDAO> results = resultRepository.findByGameId(gameId);

        return results.stream().map(ResultGetResponseDTO::of).collect(Collectors.toList());
    }

}
