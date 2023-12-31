package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulGetBean {
    private final HelpfulGetSmallBean helpfulGetSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final ReviewGetByIdSmallBean reviewGetByIdSmallBean;

    public HelpfulGetResponseDTO exec(String userId, Long reviewId) {
        UserDAO findUser = userGetByIdSmallBean.exec(userId);
        ReviewDAO findReview = reviewGetByIdSmallBean.exec(reviewId);

        boolean exec = helpfulGetSmallBean.exec(findUser, findReview);


        return HelpfulGetResponseDTO.builder()
                .helpful(exec)
                .build();
    }
}
