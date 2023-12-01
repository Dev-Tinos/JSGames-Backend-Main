package com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetReponseDTO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulGetSmallBean {
    @Autowired
    private HelpfulRepository helpfulRepository;

    public boolean exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAO =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if (!helpfulDAO.isPresent()) {
            return false;
        }
        return true;
    }
}
