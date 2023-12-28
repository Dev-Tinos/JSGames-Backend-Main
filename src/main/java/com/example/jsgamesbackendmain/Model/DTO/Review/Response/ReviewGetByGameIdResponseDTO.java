package com.example.jsgamesbackendmain.Model.DTO.Review.Response;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewGetByGameIdResponseDTO {
    private Long reviewId;

    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Long helpful;

    private LocalDateTime dateTime;

    private UserGetResponseDTO user;

    private Long gameId;

    public static ReviewGetByGameIdResponseDTO of(ReviewDAO reviewDAO, UserDAO userDAO) {
        return ReviewGetByGameIdResponseDTO.builder()
                .reviewId(reviewDAO.getReviewId())
                .reviewContent(reviewDAO.getReviewContent())
                .star(reviewDAO.getStar())
                .helpful(reviewDAO.getHelpful())
                .dateTime(reviewDAO.getDateTime())
                .user(UserGetResponseDTO.of(userDAO))
                .gameId(reviewDAO.getGameId())
                .build();
    }
}
