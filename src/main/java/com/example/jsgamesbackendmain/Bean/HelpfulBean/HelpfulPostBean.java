package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulPostBean {
    @Autowired
    private HelpfulRepository helpfulRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    public String exec(String userId, Long reviewId) {
        Optional<HelpfulDAO> helpfulDAOCheck =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if(helpfulDAOCheck.isPresent()){
            throw new DuplicateException("이미 존재하는 helpful입니다.");
        }
        HelpfulDAO helpfulDAO = new HelpfulDAO();
        helpfulDAO.setUserId(userId);
        helpfulDAO.setReviewId(reviewId);
        helpfulRepository.save(helpfulDAO);
        reviewRepository.updateHelpfulPlus(reviewId);
//        if(helpfulDAO.isPresent()){
//            //이미 존재하는 경우 helpful 값을 true로 바꿔준다.
//            helpfulDAO.get().setHelpful(true);
//            helpfulRepository.save(helpfulDAO.get());
//        }else{
//            //존재하지 않는 경우 새로 만들어준다.
//            HelpfulDAO newHelpfulDAO = new HelpfulDAO();
//            newHelpfulDAO.setUserId(userId);
//            newHelpfulDAO.setReviewId(reviewId);
//            newHelpfulDAO.setHelpful(true);
//            helpfulRepository.save(newHelpfulDAO);
//        }
        return "success";
    }
}
