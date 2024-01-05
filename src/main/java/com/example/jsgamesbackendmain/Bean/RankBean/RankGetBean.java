package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankGetTop100SmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankTop100UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RankGetBean {

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
