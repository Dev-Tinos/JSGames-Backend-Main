package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetTop100SmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankGetBean {

    @Autowired
    private RankGetTop100SmallBean rankGetTop100SmallBean;
    @Autowired
    private RankLastUpdatedSmallBean rankLastUpdatedSmallBean;
    public RankGetResponseDTO exec(Long page, Long size) {
        RankGetResponseDTO responseDTO = new RankGetResponseDTO();
        // RankTop100 DAO to Rank
        responseDTO.setRankList(rankGetTop100SmallBean.exec(page, size));
        responseDTO.setLastUpdated(rankLastUpdatedSmallBean.getLastUpdated());

        return responseDTO;
    }
}
