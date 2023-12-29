package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankMajorResponseDTO {
    private Major major;
    private Long rankWeight;
    private Integer totalRank;

    public static RankMajorResponseDTO of(Major major, Long rankWeight, Integer totalRank) {
        return RankMajorResponseDTO.builder()
                .major(major)
                .rankWeight(rankWeight)
                .totalRank(totalRank)
                .build();
    }
}
