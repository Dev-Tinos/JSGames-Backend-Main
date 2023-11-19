package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetTop100SmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankTop100UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RankGetBean {

    @Autowired
    private RankGetTop100SmallBean rankGetTop100SmallBean;
    @Autowired
    private RankLastUpdatedSmallBean rankLastUpdatedSmallBean;
    public RankGetResponseDTO exec(Long page, Long size) {
        RankGetResponseDTO responseDTO = new RankGetResponseDTO();

        List<RankTop100UserResponseDTO> list = rankGetTop100SmallBean.exec(page, size);
        LocalDateTime lastUpdateDated = rankLastUpdatedSmallBean.exec();
        // RankTop100 DAO to Rank
        responseDTO.setRankList(list);
        responseDTO.setLastUpdated(lastUpdateDated);
        return responseDTO;
    }
}
