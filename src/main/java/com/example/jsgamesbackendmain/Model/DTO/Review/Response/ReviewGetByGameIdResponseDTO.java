package com.example.jsgamesbackendmain.Model.DTO.Review.Response;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewGetByGameIdResponseDTO {

    private Long reviewId;
    private UserGetResponseDTO user;
    private Long gameId;
    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Float helpful;

    private LocalDateTime dateTime;
}
