package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import lombok.*;

import javax.validation.constraints.Max;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUpdateRequestDTO {
    private String reviewContent;
    @Max(5)
    private Float star;
}