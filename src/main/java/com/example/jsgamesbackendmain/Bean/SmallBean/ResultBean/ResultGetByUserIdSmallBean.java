package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultGetByUserIdSmallBean {
    @Autowired
    private ResultRepository resultRepository;

    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(Long userId) {
        return resultRepository.findByUserId(userId);
    }
}
