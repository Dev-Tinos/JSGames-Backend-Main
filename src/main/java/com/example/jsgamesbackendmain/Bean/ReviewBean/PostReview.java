package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostReview {

    private final ReviewSaveSmallBean reviewSaveSmallBean;

    private final UserGetByIdSmallBean userGetByIdSmallBean;

    private final GameGetSmallBean gameGetSmallBean;

    public ReviewCreateResponseDTO exec(ReviewCreateRequestDTO requestDTO) {

        // user validation
        UserDAO findUser = userGetByIdSmallBean.exec(requestDTO.getUserId());

        // game validation
        GameDAO findGame = gameGetSmallBean.exec(requestDTO.getGameId());

        return ReviewCreateResponseDTO.of(reviewSaveSmallBean.exec(requestDTO.toDAO(), findUser, findGame));
    }
}
