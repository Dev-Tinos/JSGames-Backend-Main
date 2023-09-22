package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ResultBean.ResultPostBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Result.ResultPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    private ResultGetBean resultGetBean;
    @Autowired
    private ResultPostBean resultPostBean;

//    public ResultDTO getResult(Long gameId) {
//        return resultGetBean.getResult(gameId);
//    }

    public ResultDTO postResult(ResultPostDTO resultPostDTO) {
        return resultPostBean.postResult(resultPostDTO);
    }
}
