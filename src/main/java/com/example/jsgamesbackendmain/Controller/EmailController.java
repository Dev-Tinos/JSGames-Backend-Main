package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Operation(summary = "인증 코드 전송 api ", description =
            "# 해당 이메일로 인증 코드를 전송해주는 api\n"+
                    "## 동일 이메일에는 한개의 메일만 전송 (2개의 메일 불가능)\n"+
                    "## 이미 가입된 이메일 사용 불가\n"+
                    "## @tukorea.ac.kr 인 도메인만 사용 가능" +
                    "## 오류 뜰시에 /email/clear api 실행해주세요"
            
    )
    @PostMapping("/email")
    public StateResponseDTO sendEmail(@RequestBody EmailSendRequestDTO emailRequestDTO) {
        return emailService.sendEmail(emailRequestDTO);
    }
}
