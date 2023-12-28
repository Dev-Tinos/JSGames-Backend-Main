package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulDeleteBean;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulGetBean;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulPostBean;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelpfulService {
    private final HelpfulGetBean helpfulGetBean;
    private final HelpfulPostBean helpfulPostBean;
    private final HelpfulDeleteBean helpfulDeleteBean;

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 조회 API
    public HelpfulGetResponseDTO getHelpful(String userId, Long reviewId) {
        return helpfulGetBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 추가 API
    public StateResponseDTO postHelpful(String userId, Long reviewId) {
        return helpfulPostBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 삭제 API
    public StateResponseDTO deleteHelpful(String userId, Long reviewId) {
        return helpfulDeleteBean.exec(userId, reviewId);
    }
}
