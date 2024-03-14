package com.example.jsgamesbackendmain.Bean.ReportReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ReportReviewBean.ReportReviewSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReportReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Request.ReportReviewPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Response.ReportReviewPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportReviewSaveBean {

    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final ReviewGetByIdSmallBean reviewGetByIdSmallBean;
    private final ReportReviewSaveSmallBean reportReviewSaveSmallBean;

    public ReportReviewPostResponseDTO exec(ReportReviewPostRequestDTO requestDTO) {
        // 사용자있는지 확인
        UserDAO reporter = userGetByIdSmallBean.exec(requestDTO.getReporterId());
        // 신고당한 리뷰가 있는지 확인
        ReviewDAO reportedReview = reviewGetByIdSmallBean.exec(requestDTO.getReportedReviewId());
        // 신고 리뷰 저장
        ReportReviewDAO savedReportReview = reportReviewSaveSmallBean.exec(reportedReview, reporter);
        return ReportReviewPostResponseDTO.of(savedReportReview);
    }
}
