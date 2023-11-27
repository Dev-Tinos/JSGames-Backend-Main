package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulPostSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelpfulPostBean {
    @Autowired
    private HelpfulPostSmallBean helpfulPostSmallBean;
    public StateResponseDTO exec(String userId, Long reviewId) {
        helpfulPostSmallBean.exec(userId, reviewId);
        return new StateResponseDTO(true);
    }
}
