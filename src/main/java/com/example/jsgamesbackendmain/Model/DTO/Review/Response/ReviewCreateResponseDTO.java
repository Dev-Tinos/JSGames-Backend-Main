package com.example.jsgamesbackendmain.Model.DTO.Review.Response;


import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCreateResponseDTO {
    private Long reviewId;

    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Long helpful;

    private LocalDateTime dateTime;

    private String userId;

    private Long gameId;

    public static ReviewCreateResponseDTO of(ReviewDAO review) {
        return ReviewCreateResponseDTO.builder()
                .reviewId(review.getReviewId())
                .reviewContent(review.getReviewContent())
                .star(review.getStar())
                .helpful(review.getHelpful())
                .dateTime(review.getDateTime())
                .userId(review.getUser().getUserId())
                .gameId(review.getGame().getGameId())
                .build();
    }
}
