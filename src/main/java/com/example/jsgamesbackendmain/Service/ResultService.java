package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ResultBean.ResultGetByUserIdBean;
import com.example.jsgamesbackendmain.Bean.ResultBean.ResultPostBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Result.Request.ResultPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultGetSmallBean resultGetSmallBean;
    @Autowired
    private ResultGetByUserIdBean resultGetByUserIdBean;
    @Autowired
    private ResultPostBean resultPostBean;

//    public  getResult(Long gameId) {
//        return resultGetBean.getResult(gameId);
//    }

    public ResultPostResponseDTO postResult(ResultPostRequestDTO resultPostRequestDTO) {
        return resultPostBean.postResult(resultPostRequestDTO);
    }

    public List<ResultGetResponseDTO> getResultsByGameId(Long gameId) {
        return resultGetSmallBean.getResultsByGameId(gameId);
    }

    public List<ResultGetByUserIdResponseDTO> getResultsByUserId(Long userId) {
        return resultGetByUserIdBean.getResultsByUserId(userId);
    }
}
