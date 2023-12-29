package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulPostSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulPostBean {
    private final HelpfulPostSmallBean helpfulPostSmallBean;
    public StateResponseDTO exec(String userId, Long reviewId) {

        helpfulPostSmallBean.exec(userId, reviewId);
        return new StateResponseDTO(true);
    }
}
