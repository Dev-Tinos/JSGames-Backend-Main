package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Model.DAO.RankMajorDAO;
import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Request.RankGetRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Request.RankMajorGetRequestDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import com.example.jsgamesbackendmain.Repository.RankTop100Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RankMajorSaveSmallBean {
    private final ObjectMapper objectMapper;
    private final RankMajorRepository rankMajorRepository;
    public void exec(Major major) {
        List<RankMajorDAO> list =
                rankMajorRepository.findAllByOrderByRankWeightDesc(major)
                        .stream()
                        .map(map -> objectMapper.convertValue(map, RankMajorGetRequestDTO.class).toDAO())
                        .collect(Collectors.toList());

        rankMajorRepository.saveAll(list);
    }
}
