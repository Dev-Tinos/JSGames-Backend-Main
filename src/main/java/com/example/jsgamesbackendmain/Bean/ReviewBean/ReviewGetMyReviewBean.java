package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByUserIdAndGameIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewGetMyReviewBean {
    private final ReviewGetByUserIdAndGameIdSmallBean reviewGetByUserIdAndGameIdSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final GameGetSmallBean gameGetSmallBean;

    public ReviewGetByGameIdResponseDTO exec(Long gameId, String userId) {

        userGetByIdSmallBean.exec(userId);

        gameGetSmallBean.exec(gameId);

        ReviewDAO findReview = reviewGetByUserIdAndGameIdSmallBean.exec(userId, gameId);

        return ReviewGetByGameIdResponseDTO.of(findReview);
    }
}
