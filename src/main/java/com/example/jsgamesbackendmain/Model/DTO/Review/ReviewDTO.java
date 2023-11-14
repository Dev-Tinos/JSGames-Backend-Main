package com.example.jsgamesbackendmain.Model.DTO.Review;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class ReviewDTO {
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
