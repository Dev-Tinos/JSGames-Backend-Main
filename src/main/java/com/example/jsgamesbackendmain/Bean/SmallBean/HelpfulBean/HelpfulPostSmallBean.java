package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelpfulPostSmallBean {
    private final HelpfulRepository helpfulRepository;
    private final ReviewRepository reviewRepository;

    public void exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if (helpfulDAOCheck.isPresent()) {
            throw new DuplicateException("이미 존재하는 helpful입니다.");
        }
        HelpfulDAO helpfulDAO = HelpfulDAO.builder().build();
        helpfulDAO.setUserId(userId);
        helpfulDAO.setReviewId(reviewId);

        helpfulRepository.save(helpfulDAO);
        reviewRepository.updateHelpfulPlus(reviewId);
    }
}
