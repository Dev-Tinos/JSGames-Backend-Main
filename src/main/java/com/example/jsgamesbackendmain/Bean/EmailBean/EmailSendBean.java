package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Random;

// ... other imports ...

@Component
public class EmailSendBean {

    @Autowired
    private EmailAccountRepository emailAccountRepository;

    @Autowired
    private EmailCodeRepository emailCodeRepository;

    @Autowired
    private JavaMailSender emailSender; // 자동 설정된 빈을 주입

    private static final String DOMAIN = "@tukorea.ac.kr";
    private static final int CODE_EXPIRATION_DURATION_MINUTES = 60; // 예시로 코드 만료 시간을 60분으로 설정

    public String exec(EmailSendRequestDTO emailSendRequestDTO) {
        // 이메일 도메인 검증
        String recipientEmail = emailSendRequestDTO.getEmail();
        if (!recipientEmail.endsWith(DOMAIN)) {
            return "Invalid email domain";
        }

        // 인증 코드 생성
        String verificationCode = generateVerificationCode();

        // 인증 코드 저장 (데이터베이스)
        EmailCodeDAO newCode = new EmailCodeDAO();
        newCode.setEmail(recipientEmail);
        newCode.setCode(verificationCode);
        newCode.setExpiryDate(LocalDateTime.now().plusMinutes(CODE_EXPIRATION_DURATION_MINUTES));
        emailCodeRepository.save(newCode);

        // 이메일 발송
        try {
            sendVerificationEmail(recipientEmail, verificationCode);
        } catch (MessagingException e) {
            // 이메일 전송 중 문제 발생 시 로깅 또는 예외 처리
            return "Failed to send the email";
        }

        // sentEmails 카운트 업데이트
        EmailAccountDAO account = emailAccountRepository.findById(0L).orElse(null);
        if (account == null) {
            account = new EmailAccountDAO();
            account.setId(0L);
            account.setSentEmails(1L); // 처음 이메일을 보내므로 1로 설정
        } else {
            account.setSentEmails(account.getSentEmails() + 1);
        }
        emailAccountRepository.save(account);

        return "Code sent";
    }

    private String generateVerificationCode() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    private void sendVerificationEmail(String to, String code) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("tukorea.tino.project@gmail.com"); // 발신자의 Gmail 주소
        helper.setTo(to);
        helper.setSubject("Verification Code");
        helper.setText("Your verification code is: " + code);

        emailSender.send(message);
    }
}
