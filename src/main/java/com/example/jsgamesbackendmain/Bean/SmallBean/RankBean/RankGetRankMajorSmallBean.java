package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankMajorResponseDTO;
import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RankGetRankMajorSmallBean {
    private final RankMajorRepository rankMajorRepository;

    public List<RankMajorResponseDTO> exec() {
        return rankMajorRepository.findAllByMajorASC()
                .stream()
                .map(rankMajorDAO -> RankMajorResponseDTO.of(rankMajorDAO.getMajor(), rankMajorDAO.getRankWeight(), rankMajorDAO.getTotalRank()))
                .toList();
    }
}
