package com.example.jsgamesbackendmain.Bean.SmallBean.ReportLogBean;


import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReportLogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.ReportLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReportLogSaveSmallBean {
    private final ReportLogRepository reportLogRepository;

    public ReportLogDAO exec(LogDAO reportedLog, UserDAO reporter) {
        Optional<ReportLogDAO> reportLogOpt = reportLogRepository.findByReportedLogAndReporter(reportedLog, reporter);

        if(reportLogOpt.isPresent()) {
           throw new InvalidException("이미 신고한 기록 입니다.");
        }

        ReportLogDAO newReportLog = ReportLogDAO.builder()
                .reporter(reporter)
                .reportedLog(reportedLog)
                .build();

        return reportLogRepository.save(newReportLog);
    }
}
