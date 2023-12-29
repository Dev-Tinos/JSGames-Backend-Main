package com.example.jsgamesbackendmain.Model.DTO.Rank.Request;

import com.example.jsgamesbackendmain.Model.DAO.RankMajorDAO;
import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RankMajorGetRequestDTO {
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("total_rank")
    private Integer totalRank;
    @JsonProperty("rank_weight")
    private Long rankWeight;
    @JsonProperty("major")
    private Major major;

    public RankMajorDAO toDAO() {
        return RankMajorDAO.builder()
                .userId(userId)
                .totalRank(totalRank)
                .rankWeight(rankWeight)
                .major(major)
                .build();
    }
}
