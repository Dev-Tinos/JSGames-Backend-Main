package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulDeleteBean {
    private final HelpfulDeleteSmallBean helpfulDeleteSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final ReviewGetByIdSmallBean reviewGetByIdSmallBean;

    public StateResponseDTO exec(String userId, Long reviewId) {
        UserDAO findUser = userGetByIdSmallBean.exec(userId);
        ReviewDAO findReview = reviewGetByIdSmallBean.exec(reviewId);

        helpfulDeleteSmallBean.exec(findUser, findReview);
        return new StateResponseDTO(true);
    }
}
