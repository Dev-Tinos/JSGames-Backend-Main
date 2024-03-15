package com.example.jsgamesbackendmain.Bean.SmallBean.ReportReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.ReportReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.ReportReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReportReviewSaveSmallBean {
    private final ReportReviewRepository reportReviewRepository;

    public ReportReviewDAO exec(ReviewDAO review, UserDAO userDAO) {
        Optional<ReportReviewDAO> reportReviewOpt =
                reportReviewRepository.findByReportedReviewAndReporter(review, userDAO);

        if (reportReviewOpt.isPresent()) {
            throw new InvalidException("이미 신고한 리뷰입니다.");
        }

        ReportReviewDAO reportReview = ReportReviewDAO.builder()
                .reporter(userDAO)
                .reportedReview(review)
                .build();

        return reportReviewRepository.save(reportReview);
    }
}
