package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RankTop100UserResponseDTO {
    private Long rankId ;
    private UserLogResponseDTO user;
    private Long score;
}
