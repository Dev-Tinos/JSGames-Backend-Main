package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailSendBean;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailSendBean emailSendBean;

    public StateResponseDTO sendEmail(EmailSendRequestDTO emailSendRequestDTO) {
        return emailSendBean.exec(emailSendRequestDTO);
    }
}
