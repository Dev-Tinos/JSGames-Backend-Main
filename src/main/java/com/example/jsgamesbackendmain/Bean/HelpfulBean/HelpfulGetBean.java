package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulGetSmallBean;
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
    private HelpfulGetSmallBean helpfulGetSmallBean;

    public HelpfulGetReponseDTO exec(String userId, Long reviewId) {
        HelpfulGetReponseDTO responseDTO = new HelpfulGetReponseDTO();
        responseDTO.setHelpful(helpfulGetSmallBean.exec(userId, reviewId));
        return responseDTO;
    }
}
