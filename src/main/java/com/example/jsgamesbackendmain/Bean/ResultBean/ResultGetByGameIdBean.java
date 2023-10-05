package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameValidationSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultGetByGameIdBean {
    @Autowired
    private ResultGetByGameIdSmallBean resultGetByGameIdSmallBean;

    @Autowired
    private GameValidationSmallBean gameValidationSmallBean;

    public List<ResultGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size) {

        //gameId 유효성 확인
        gameValidationSmallBean.exec(gameId);

        return resultGetByGameIdSmallBean.exec(gameId, page, size);
    }

}
