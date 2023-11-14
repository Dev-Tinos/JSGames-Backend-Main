package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewUpdateBean {

    @Autowired
    private ReviewRepository reviewRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public ReviewDTO exec(Long reviewId, ReviewUpdateRequestDTO requestDTO) {

        ReviewDAO dao = reviewRepository.findById(reviewId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found for this id :: " + reviewId)
        );

        dao.setReviewContent(requestDTO.getReviewContent());

        ReviewDAO savedDao = reviewRepository.save(dao);

        return objectMapper.convertValue(savedDao, ReviewDTO.class);
    }
}
