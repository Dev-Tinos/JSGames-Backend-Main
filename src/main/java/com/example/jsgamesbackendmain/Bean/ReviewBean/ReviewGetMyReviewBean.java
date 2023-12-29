package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByUserIdAndGameIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
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

        UserDAO findUser = userGetByIdSmallBean.exec(userId);

        GameDAO findGame = gameGetSmallBean.exec(gameId);

        ReviewDAO findReview = reviewGetByUserIdAndGameIdSmallBean.exec(findUser, findGame);

        return ReviewGetByGameIdResponseDTO.of(findReview);
    }
}
