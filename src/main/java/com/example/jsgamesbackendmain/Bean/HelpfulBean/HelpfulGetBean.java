package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.HelpfulBean.HelpfulGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpfulGetBean {
    private final HelpfulGetSmallBean helpfulGetSmallBean;

    public HelpfulGetResponseDTO exec(String userId, Long reviewId) {
        boolean exec = helpfulGetSmallBean.exec(userId, reviewId);


        return HelpfulGetResponseDTO.builder()
                .helpful(exec)
                .build();
    }
}
