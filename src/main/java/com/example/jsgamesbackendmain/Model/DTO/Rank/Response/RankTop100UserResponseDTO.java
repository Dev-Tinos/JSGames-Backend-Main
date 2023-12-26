package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankTop100UserResponseDTO {
    private Long rankId ;
    private UserLogResponseDTO user;
    private Long rankWeight;
    private Integer totalRank;

    public static RankTop100UserResponseDTO of(RankTop100DAO rankTop100DAO, UserDAO userDAO) {
        return RankTop100UserResponseDTO.builder()
                .rankId(rankTop100DAO.getRankId())
                .user(UserLogResponseDTO.of(userDAO))
                .rankWeight(rankTop100DAO.getRankWeight())
                .totalRank(rankTop100DAO.getTotalRank())
                .build();
    }
}
