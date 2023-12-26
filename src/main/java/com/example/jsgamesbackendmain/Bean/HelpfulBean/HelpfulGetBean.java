package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetReponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulGetBean {
    private final HelpfulGetSmallBean helpfulGetSmallBean;

    public HelpfulGetReponseDTO exec(String userId, Long reviewId) {
        HelpfulGetReponseDTO responseDTO = new HelpfulGetReponseDTO();
        responseDTO.setHelpful(helpfulGetSmallBean.exec(userId, reviewId));
        return responseDTO;
    }
}
