package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulDeleteBean;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulGetBean;
import com.example.jsgamesbackendmain.Bean.HelpfulBean.HelpfulPostBean;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetReponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpfulService {
    @Autowired
    private HelpfulGetBean helpfulGetBean;
    @Autowired
    private HelpfulPostBean helpfulPostBean;
    @Autowired
    private HelpfulDeleteBean helpfulDeleteBean;

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 조회 API
    public HelpfulGetReponseDTO getHelpful(String userId, Long reviewId) {
        return helpfulGetBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 추가 API
    public String postHelpful(String userId, Long reviewId) {
        return helpfulPostBean.exec(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 삭제 API
    public String deleteHelpful(String userId, Long reviewId) {
        return helpfulDeleteBean.exec(userId, reviewId);
    }
}
