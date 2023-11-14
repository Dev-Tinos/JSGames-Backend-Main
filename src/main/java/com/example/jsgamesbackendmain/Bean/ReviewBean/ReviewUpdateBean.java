package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewUpdateBean {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDTO exec(Long reviewId, ReviewUpdateRequestDTO requestDTO) {
//        ReviewDAO comment = reviewRepository.findById(commentId).orElseThrow(() ->
//                new ResourceNotFoundException("Comment not found for this id :: " + commentId)
//        );
//
//        comment.setReviewContent(requestDTO.getCommentContent());
//
//        ReviewDAO updatedComment = reviewRepository.save(comment);
//
//        return ReviewDTO.of(updatedComment);

        return null;
    }
}
