package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankByMajorUserResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RankGetByMajorSmallBean {
    private final RankMajorRepository rankMajorRepository;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public List<RankByMajorUserResponseDTO> exec(Integer page, Integer size, Major major) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return rankMajorRepository.findAllByMajorOrderByTotalRankAsc(pageRequest, major).toList()
                .stream()
                .map(rankMajorDAO -> RankByMajorUserResponseDTO.of(
                        rankMajorDAO, userGetByIdSmallBean.exec(rankMajorDAO.getUserId()))
                )
                .collect(Collectors.toList());
    }
}
