package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewDaoToResponseDtoSmallBean {

    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public ReviewGetByGameIdResponseDTO exec(ReviewDAO reviewDAO) {

        UserDAO userDAO = userGetByIdSmallBean.exec(reviewDAO.getUserId());

        return ReviewGetByGameIdResponseDTO.of(reviewDAO, userDAO);
    }
}
