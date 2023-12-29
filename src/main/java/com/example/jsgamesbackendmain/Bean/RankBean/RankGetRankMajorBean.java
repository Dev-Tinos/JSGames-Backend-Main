package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetRankMajorSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankMajorLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankMajorGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankGetRankMajorBean {
    private final RankMajorLastUpdatedSmallBean rankMajorLastUpdatedSmallBean;
    private final RankGetRankMajorSmallBean rankGetRankMajorSmallBean;

    public RankMajorGetResponseDTO exec() {
        return RankMajorGetResponseDTO
                .builder()
                .lastUpdated(rankMajorLastUpdatedSmallBean.getLastUpdated())
                .rankList(rankGetRankMajorSmallBean.exec())
                .build();
    }
}