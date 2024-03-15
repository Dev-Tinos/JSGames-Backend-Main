package com.example.jsgamesbackendmain.Bean.ReportLogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReportLogBean.ReportLogSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReportLogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Request.ReportLogRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Response.ReportLogResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportLogSaveBean {
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final LogGetByIdSmallBean logGetByIdSmallBean;
    private final ReportLogSaveSmallBean reportLogSaveSmallBean;

    public ReportLogResponseDTO exec(ReportLogRequestDTO request) {
        // 사용자있는지 확인
        UserDAO reporter = userGetByIdSmallBean.exec(request.getReporterId());
        // 신고당한 로그가 있는지 확인
        LogDAO reportedLog = logGetByIdSmallBean.exec(request.getReportedLogId());

        // 신고 로그 저장
        ReportLogDAO savedReportLog = reportLogSaveSmallBean.exec(reportedLog, reporter);
        return ReportLogResponseDTO.of(savedReportLog);
    }
}
