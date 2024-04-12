package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetTop100SmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetRank {

    private final RankGetTop100SmallBean rankGetTop100SmallBean;
    private final RankLastUpdatedSmallBean rankLastUpdatedSmallBean;

    public RankGetResponseDTO exec(Integer page, Integer size) {
        // RankTop100 DAO to Rank

        return RankGetResponseDTO
                .builder()
                .lastUpdated(rankLastUpdatedSmallBean.getLastUpdated())
                .rankList(rankGetTop100SmallBean.exec(page, size))
                .build();
    }
}
