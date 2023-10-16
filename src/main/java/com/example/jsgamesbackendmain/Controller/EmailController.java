package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email")
    public String sendEmail(@RequestBody EmailSendRequestDTO emailRequestDTO) {
        return emailService.sendEmail(emailRequestDTO);
    }

    @Operation(summary = "이메일 코드 테이블 데이터 삭제", description =
                    "## 또한 자동으로 오후 11시 55분 마다 자동으로 실행됨"
    )
    @PostMapping("/email/clear")
    public String emailClear(){
        return emailService.emailClear();
    }
}
