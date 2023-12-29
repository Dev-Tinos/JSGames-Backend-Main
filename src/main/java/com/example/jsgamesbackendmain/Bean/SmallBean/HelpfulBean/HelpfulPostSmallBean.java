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

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelpfulPostSmallBean {
    private final HelpfulRepository helpfulRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public void exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserAndReview(userId, reviewId);

        if (helpfulDAOCheck.isPresent()) {
            throw new DuplicateException("이미 존재하는 helpful입니다.");
        }

        UserDAO findUser = userRepository.findById(userId).get();
        ReviewDAO findReview = reviewRepository.findById(reviewId).get();


        HelpfulDAO helpfulDAO = HelpfulDAO.builder().build();
        helpfulDAO.setUser(findUser);
        helpfulDAO.setReview(findReview);

        helpfulRepository.save(helpfulDAO);
        reviewRepository.updateHelpfulPlus(reviewId);
    }
}
