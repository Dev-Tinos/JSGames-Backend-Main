package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulDeleteSmallBean {
    @Autowired
    private HelpfulRepository helpfulRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public void exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if(!helpfulDAOCheck.isPresent()){
            throw new DuplicateException("존재하지 않는 helpful입니다.");
        }
        helpfulRepository.deleteByUserIdAndReviewId(userId, reviewId);
        reviewRepository.updateHelpfulMinus(reviewId);
    }
}
