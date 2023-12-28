package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankByMajorUserResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RankGetByMajorSmallBean {
    private final RankMajorRepository rankMajorRepository;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public List<RankByMajorUserResponseDTO> exec(Major major) {
        return rankMajorRepository.findAllByMajorOrderByTotalRankAsc(major)
                .stream()
                .map(rankMajorDAO -> RankByMajorUserResponseDTO.of(
                        rankMajorDAO, userGetByIdSmallBean.exec(rankMajorDAO.getUserId()))
                )
                .toList();
    }
}
