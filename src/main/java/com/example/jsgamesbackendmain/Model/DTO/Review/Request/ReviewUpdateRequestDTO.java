package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewUpdateRequestDTO {
    private String reviewContent;
}