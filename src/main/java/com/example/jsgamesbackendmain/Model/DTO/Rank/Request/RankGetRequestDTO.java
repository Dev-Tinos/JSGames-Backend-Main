package com.example.jsgamesbackendmain.Model.DTO.Rank.Request;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RankGetRequestDTO {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("total_rank")
    private Integer totalRank;
    @JsonProperty("rank_weight")
    private Long rankWeight;

    public RankTop100DAO toDAO() {
        RankTop100DAO dao = new RankTop100DAO();
        dao.setUserId(userId);
        dao.setTotalRank(totalRank);
        dao.setRankWeight(rankWeight);
        return dao;
    }
}
