package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ResultGetBean {

    @Autowired
    private ResultRepository resultRepository;

    public List<ResultGetResponseDTO> getResultByGameId(Long gameId) {

        List<ResultDAO> results = resultRepository.findByGameId(gameId);
        // to ResultDTO
        return results.stream().map(ResultGetResponseDTO::of).collect(Collectors.toList());
    }

}
