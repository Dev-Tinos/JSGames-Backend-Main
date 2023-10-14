package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGetTop100Response {
    private Long top100Id;
    private Long userId;
    private Long score;

    public static UserGetTop100Response of(UserTop100DAO userTop100DAO) {
        UserGetTop100Response userGetTop100Response = new UserGetTop100Response();

        userGetTop100Response.setTop100Id(userTop100DAO.getTop100Id());
        userGetTop100Response.setUserId(userTop100DAO.getUserId());
        userGetTop100Response.setScore(userTop100DAO.getScore());

        return userGetTop100Response;
    }
}
