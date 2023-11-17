package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.UserWeight.RankWeightDTO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import com.example.jsgamesbackendmain.Repository.RankWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankSaveSmallBean {
    @Autowired
    private RankWeightRepository rankWeightRepository;
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private RankLastUpdatedSmallBean rankLastUpdatedSmallBean;
    public void exec() {
        rankLastUpdatedSmallBean.setLastUpdated();

        List<RankWeightDTO> weightDTOList = rankWeightRepository.findRankWeightSum(PageRequest.of(0, 100)).toList();
        for (RankWeightDTO weightDTO : weightDTOList) {
            RankTop100DAO dao = new RankTop100DAO();
            dao.setUserId(weightDTO.getUserId());
            dao.setScore(weightDTO.getWeightSum());
            rankRepository.save(dao);
        }
    }
}
