package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewUpdateSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(ReviewDAO review, ReviewUpdateRequestDTO request) {
        // 리뷰 내용 업데이트
        review.update(request);
        return reviewRepository.save(review);
    }

}
