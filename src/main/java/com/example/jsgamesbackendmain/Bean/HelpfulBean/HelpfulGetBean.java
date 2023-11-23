package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetReponseDTO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulGetBean {
    @Autowired
    private HelpfulRepository helpfulRepository;

    public HelpfulGetReponseDTO exec(String userId, Long reviewId) {
        HelpfulGetReponseDTO responseDTO = new HelpfulGetReponseDTO();
        Optional<HelpfulDAO> helpfulDAO =
                helpfulRepository.findByUserIdAndReviewId(userId, reviewId);
        if (!helpfulDAO.isPresent()) {
//            throw new ResourceNotFoundException("Helpful not found for this id :: " + userId);
            responseDTO.setHelpful(false);
        } else {
//            responseDTO.setHelpful(helpfulDAO.get().getHelpful());
            responseDTO.setHelpful(true);
        }
        return responseDTO;
    }
}
