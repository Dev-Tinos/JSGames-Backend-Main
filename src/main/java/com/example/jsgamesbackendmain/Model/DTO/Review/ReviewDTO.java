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

    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Long helpful;

    private LocalDateTime dateTime;
}
