package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewGetByIdSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() ->
                new ResourceNotFoundException("Review not found for this id :: " + reviewId)
        );
    }
}
