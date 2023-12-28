package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankTop100UserResponseDTO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RankGetTop100SmallBean {
    private final RankRepository rankRepository;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public List<RankTop100UserResponseDTO> exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());
        return rankRepository.findAllByOrderByTotalRankAsc(pageRequest).toList()
                .stream()
                .map(rankTop100DAO -> RankTop100UserResponseDTO.of(
                        rankTop100DAO, userGetByIdSmallBean.exec(rankTop100DAO.getUserId()))
                )
                .collect(Collectors.toList());
    }
}
