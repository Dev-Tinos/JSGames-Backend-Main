package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGetTop100ResponseDTO {
    private Long top100Id;
    private Long userId;
    private Long score;
}
