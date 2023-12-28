package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Request.RankMajorGetRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankMajorResponseDTO;
import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RankGetRankMajorSmallBean {
    private final RankMajorRepository rankMajorRepository;
    private final ObjectMapper objectMapper;

    public List<RankMajorResponseDTO> exec() {
        return rankMajorRepository.findAllByMajorASC()
                .stream()
                .map(map -> objectMapper.convertValue(map, RankMajorResponseDTO.class))
                .collect(Collectors.toList());
    }
}
