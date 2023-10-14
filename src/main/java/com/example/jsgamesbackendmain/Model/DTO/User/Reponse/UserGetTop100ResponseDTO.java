package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGetTop100ResponseDTO {
    private Long top100Id;
    private Long userId;
    private Long score;

    public static UserGetTop100ResponseDTO of(UserTop100DAO userTop100DAO) {
        UserGetTop100ResponseDTO userGetTop100ResponseDTO = new UserGetTop100ResponseDTO();

        userGetTop100ResponseDTO.setTop100Id(userTop100DAO.getTop100Id());
        userGetTop100ResponseDTO.setUserId(userTop100DAO.getUserId());
        userGetTop100ResponseDTO.setScore(userTop100DAO.getScore());

        return userGetTop100ResponseDTO;
    }
}
