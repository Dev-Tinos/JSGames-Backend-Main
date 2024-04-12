package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.HelpfulBean.DeleteHelpful;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.GetHelpful;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.PostHelpful;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HelpfulService {
    private final GetHelpful helpfulGetBean;
    private final PostHelpful helpfulPostBean;
    private final DeleteHelpful helpfulDeleteBean;

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 조회 API
    @Transactional
    public HelpfulGetResponseDTO getHelpful(String userId, Long reviewId) {
        return helpfulGetBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 추가 API
    @Transactional
    public StateResponseDTO postHelpful(String userId, Long reviewId) {
        return helpfulPostBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 삭제 API
    @Transactional
    public StateResponseDTO deleteHelpful(String userId, Long reviewId) {
        return helpfulDeleteBean.exec(userId, reviewId);
    }
}
