package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.FailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSendSmallBean {
    @Autowired
    private JavaMailSender emailSender; // 자동 설정된 빈을 주입

    @Value("${spring.mail.username}")
    private String myEmail;

    public void exec(String to, String code){
        try {
            sendEmail(to, code);
        } catch (MessagingException e) {
            throw new FailException("이메일 전송 실패");
        }
    }
    private void sendEmail(String to, String code) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(myEmail); // 발신자의 Gmail 주소
        helper.setTo(to);
        helper.setSubject("Verification Code");
        helper.setText("Your verification code is: " + code);

        emailSender.send(message);
    }
}
