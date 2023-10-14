package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ResultBean.ResultGetByGamIdUserIdBean;
import com.example.jsgamesbackendmain.Bean.ResultBean.ResultGetByGameIdBean;
import com.example.jsgamesbackendmain.Bean.ResultBean.ResultGetByUserIdBean;
import com.example.jsgamesbackendmain.Bean.ResultBean.ResultPostBean;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private ResultGetByGameIdBean resultGetByGameIdBean;
    @Autowired
    private ResultGetByUserIdBean resultGetByUserIdBean;
    @Autowired
    private ResultGetByGamIdUserIdBean resultGetByGamIdUserIdBean;
    @Autowired
    private ResultPostBean resultPostBean;

    public ResultPostResponseDTO postResult(ResultPostRequestDTO resultPostRequestDTO) {
        return resultPostBean.postResult(resultPostRequestDTO);
    }

    public List<ResultGetByGameIdResponseDTO> getResultsByGameId(Long gameId, Long page, Long size) {
        List<ResultDAO> daoList = resultGetByGameIdBean.exec(gameId, page, size);
        return daoList.stream().map(ResultGetByGameIdResponseDTO::of).collect(Collectors.toList());
    }

    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(Long userId, Long page, Long size) {
        return resultGetByUserIdBean.exec(userId, page, size);
    }

    public ResultGetByGameIdUserIdResponseDTO getResultByGameIdUserId(Long gameId, Long userId) {
        return resultGetByGamIdUserIdBean.exec(gameId, userId);
    }
}
