package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.example.jsgamesbackendmain.Model.DAO.RankMajorDAO;
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
public class RankByMajorUserResponseDTO {
    private Long rankId ;
    private UserLogResponseDTO user;
    private Long rankWeight;
    private Integer totalRank;
    private Major major;

    public static RankByMajorUserResponseDTO of(RankMajorDAO rankMajorDAO, UserDAO userDAO) {
        return RankByMajorUserResponseDTO.builder()
                .rankId(rankMajorDAO.getRankId())
                .user(UserLogResponseDTO.of(userDAO))
                .rankWeight(rankMajorDAO.getRankWeight())
                .totalRank(rankMajorDAO.getTotalRank())
                .major(rankMajorDAO.getMajor())
                .build();
    }
}
