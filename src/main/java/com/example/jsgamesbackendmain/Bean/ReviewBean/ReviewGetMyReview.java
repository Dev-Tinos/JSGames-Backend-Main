package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByUserIdAndGameIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Converter.ReviewConverter;
import com.example.jsgamesbackendmain.Converter.UserConverter;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewGetMyReview {
    @Autowired
    private ReviewGetByUserIdAndGameIdSmallBean reviewGetByUserIdAndGameIdSmallBean;

    @Autowired
    private UserGetByIdSmallBean userGetByIdSmallBean;
    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public ReviewDTO exec(Long gameId,String userId) {

        UserDAO user = userGetByIdSmallBean.exec(userId);

        gameGetSmallBean.exec(gameId);

        ReviewDAO dao = reviewGetByUserIdAndGameIdSmallBean.exec(userId, gameId);

        return ReviewConverter.toGetByGameIdResponseDTO(
                dao,UserConverter.toUserGetResponseDTO(user)
        );
    }
}
