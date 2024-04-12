package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ReportLogBean.PostReportLog;
import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Request.ReportLogRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Response.ReportLogResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportLogService {
    private final PostReportLog reportLogSaveBean;

    public ReportLogResponseDTO reportLog(ReportLogRequestDTO request) {
        return reportLogSaveBean.exec(request);
    }
}
