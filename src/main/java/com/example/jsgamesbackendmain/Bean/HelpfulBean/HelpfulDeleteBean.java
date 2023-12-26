package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulDeleteSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulDeleteBean {
    private final HelpfulDeleteSmallBean helpfulDeleteSmallBean;

    public StateResponseDTO exec(String userId, Long reviewId) {
        helpfulDeleteSmallBean.exec(userId, reviewId);
        return new StateResponseDTO(true);
    }
}
