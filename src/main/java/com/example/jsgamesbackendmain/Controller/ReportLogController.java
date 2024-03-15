package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Request.ReportLogRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportLog.Response.ReportLogResponseDTO;
import com.example.jsgamesbackendmain.Service.ReportLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportLogController {
    private final ReportLogService reportLogService;

    @PostMapping("/log")
    public ReportLogResponseDTO reportLog(
            @RequestBody ReportLogRequestDTO request
    ) {
        return reportLogService.reportLog(request);
    }
}
