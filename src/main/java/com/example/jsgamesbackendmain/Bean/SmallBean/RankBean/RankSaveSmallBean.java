package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Request.RankGetRequestDTO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RankSaveSmallBean {
    private final ObjectMapper objectMapper;
    private final RankRepository rankRepository;
    public void exec() {
        List<RankTop100DAO> list =
                rankRepository.findAllByOrderByRankWeightDesc()
                        .stream()
                        .map(map -> objectMapper.convertValue(map, RankGetRequestDTO.class).toDAO())
                        .collect(Collectors.toList());

        rankRepository.saveAll(list);
    }
}
