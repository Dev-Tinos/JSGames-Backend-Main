package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreateRequestDTO {
    private Long userId;
    private Long gameId;
    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Float helpful;
}
