package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewUpdateSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewUpdateBean {

    private final ReviewGetByIdSmallBean reviewGetByIdSmallBean;

    private final ReviewUpdateSmallBean reviewUpdateSmallBean;


    public ReviewUpdateResponseDTO exec(Long reviewId, ReviewUpdateRequestDTO request) {

        // review validation
        ReviewDAO findReview = reviewGetByIdSmallBean.exec(reviewId);

        // update
        reviewUpdateSmallBean.exec(findReview, request);

        return ReviewUpdateResponseDTO.of(findReview);
    }
}

