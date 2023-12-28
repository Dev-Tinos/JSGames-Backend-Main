package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateRequestDTO {
    private String userId;
    private Long gameId;
    private String reviewContent;
    // 별점
    private Float star;

    public ReviewDAO toDAO() {
        return ReviewDAO.builder()
                .userId(this.getUserId())
                .gameId(this.getGameId())
                .reviewContent(this.getReviewContent())
                .star(this.getStar())
                .build();
    }

    public static ReviewCreateRequestDTO of(ReviewDAO reviewDAO) {
        return ReviewCreateRequestDTO.builder()
                .userId(reviewDAO.getUserId())
                .gameId(reviewDAO.getGameId())
                .reviewContent(reviewDAO.getReviewContent())
                .star(reviewDAO.getStar())
                .build();
    }
}
