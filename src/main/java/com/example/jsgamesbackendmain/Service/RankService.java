package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.RankBean.RankGetBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankGetByMajorBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankGetRankMajorBean;
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

    private final RankGetBean rankGetBean;
    private final RankGetByMajorBean rankGetByMajorBean;
    private final RankGetRankMajorBean rankGetRankMajor;

    @Transactional
    public RankGetResponseDTO rankGet(Integer page, Integer size) {
        return rankGetBean.exec(page, size);
    }

    @Transactional
    public RankByMajorGetResponseDTO rankGetByMajor(Major major) {
        return rankGetByMajorBean.exec(major);
    }

    @Transactional
    public RankMajorGetResponseDTO getRankMajor() {
        return rankGetRankMajor.exec();
    }
}
