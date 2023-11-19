package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewGetByIdSmallBean {
    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDAO exec(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() ->
                new ResourceNotFoundException("Review not found for this id :: " + reviewId)
        );
    }
}
