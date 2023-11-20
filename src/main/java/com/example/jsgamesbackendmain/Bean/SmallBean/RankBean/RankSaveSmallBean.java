package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Request.RankGetRequestDTO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RankSaveSmallBean {
    @Autowired
    private MapperBean mapperBean;
    @Autowired
    private RankRepository rankRepository;
    public void exec() {
        List<RankTop100DAO> list =
                rankRepository.findAllByOrderByRankWeightDesc()
                        .stream()
                        .map(map -> mapperBean.to(map, RankGetRequestDTO.class).toDAO())
                        .collect(Collectors.toList());

        rankRepository.saveAll(list);
    }
}
