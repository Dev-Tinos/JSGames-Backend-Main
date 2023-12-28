package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelpfulGetSmallBean {
    private final HelpfulRepository helpfulRepository;

    public boolean exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAO =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        return helpfulDAO.isPresent();
    }
}
