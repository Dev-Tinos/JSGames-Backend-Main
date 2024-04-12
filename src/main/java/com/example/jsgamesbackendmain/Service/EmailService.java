package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.SendEmail;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final SendEmail sendEmail;

    public StateResponseDTO sendEmail(EmailSendRequestDTO emailSendRequestDTO) {
        return sendEmail.exec(emailSendRequestDTO);
    }
}
