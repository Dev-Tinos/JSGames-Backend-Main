package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailSendBean;
import com.example.jsgamesbackendmain.Bean.EmailBean.EmailClearBean;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailSendBean emailSendBean;
    @Autowired
    private EmailClearBean emailClearBean;

    public String sendEmail(EmailSendRequestDTO emailSendRequestDTO){
        return emailSendBean.exec(emailSendRequestDTO);
    }

    public String emailClear(){
        emailClearBean.exec();
        return "success";
    }
}
