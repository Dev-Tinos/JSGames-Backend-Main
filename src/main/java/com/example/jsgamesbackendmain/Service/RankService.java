package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.RankBean.GetRank;
import com.example.jsgamesbackendmain.Bean.RankBean.GetRankInMajor;
import com.example.jsgamesbackendmain.Bean.RankBean.GetRankByMajor;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankByMajorGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankMajorGetResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RankService {

    private final GetRank rankGetBean;
    private final GetRankInMajor rankGetByMajorBean;
    private final GetRankByMajor rankGetRankMajor;

    @Transactional
    public RankGetResponseDTO rankGet(Integer page, Integer size) {
        return rankGetBean.exec(page, size);
    }

    @Transactional
    public RankByMajorGetResponseDTO rankGetByMajor(Integer page, Integer size, Major major) {
        return rankGetByMajorBean.exec(page, size, major);
    }

    @Transactional
    public RankMajorGetResponseDTO getRankMajor() {
        return rankGetRankMajor.exec();
    }
}
