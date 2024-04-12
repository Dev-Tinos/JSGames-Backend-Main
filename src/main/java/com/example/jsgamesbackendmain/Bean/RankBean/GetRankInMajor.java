package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetByMajorSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankMajorLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankByMajorGetResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetRankInMajor {
    private final RankMajorLastUpdatedSmallBean rankMajorLastUpdatedSmallBean;
    private final RankGetByMajorSmallBean rankGetByMajorSmallBean;

    public RankByMajorGetResponseDTO exec(Integer page, Integer size, Major major) {
        return RankByMajorGetResponseDTO
                .builder()
                .lastUpdated(rankMajorLastUpdatedSmallBean.getLastUpdated())
                .rankList(rankGetByMajorSmallBean.exec(page, size, major))
                .build();
    }
}
