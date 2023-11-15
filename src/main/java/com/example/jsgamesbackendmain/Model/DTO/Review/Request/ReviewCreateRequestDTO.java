package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewCreateRequestDTO {
    private Long userId;
    private Long gameId;
    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Float helpful;
}
