package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelpfulDeleteSmallBean {
    private final HelpfulRepository helpfulRepository;
    private final ReviewRepository reviewRepository;

    public void exec(UserDAO user, ReviewDAO review) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserAndReview(user, review);
        if (!helpfulDAOCheck.isPresent()) {
            throw new DuplicateException("존재하지 않는 helpful입니다.");
        }
        if (helpfulDAOCheck.get().getHelpfulTime().plusNanos(100000000).isAfter(LocalDateTime.now())) {
            throw new DuplicateException("0.1초 이내에는 helpful을 취소할 수 없습니다.");
        }
        helpfulRepository.deleteByUserAndReview(user, review);
        reviewRepository.updateHelpfulMinus(review.getReviewId());
    }
}
