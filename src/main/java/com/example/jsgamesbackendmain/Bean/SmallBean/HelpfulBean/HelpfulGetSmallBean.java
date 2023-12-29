package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class HelpfulGetSmallBean {
    private final HelpfulRepository helpfulRepository;

    public boolean exec(UserDAO user, ReviewDAO review) {
        Optional<HelpfulDAO> helpfulDAO =
                helpfulRepository.findByUserAndReview(user, review);
        return helpfulDAO.isPresent();
    }
}
