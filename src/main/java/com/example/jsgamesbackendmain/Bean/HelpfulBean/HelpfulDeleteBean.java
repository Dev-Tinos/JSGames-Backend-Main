package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulDeleteBean {
    @Autowired
    private HelpfulRepository helpfulRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    public String exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if(!helpfulDAOCheck.isPresent()){
            throw new IllegalArgumentException("존재하지 않는 helpful입니다.");
        }
        helpfulRepository.deleteByUserIdAndReviewId(userId, reviewId);
        reviewRepository.updateHelpfulMinus(reviewId);
        return "success";
    }
}
