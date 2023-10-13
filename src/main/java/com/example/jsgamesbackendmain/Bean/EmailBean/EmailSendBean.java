package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class EmailSendBean {

    @Autowired
    private EmailAccountRepository emailAccountRepository;

    @Autowired
    private EmailCodeRepository emailCodeRepository;

    private static final String DOMAIN = "@tukorea.ac.kr";
    private static final int EMAIL_LIMIT = 500;

    @Value("${mail.sender1.username}")
    private String email1;

    @Value("${mail.sender2.username}")
    private String email2;

    @Value("${mail.sender3.username}")
    private String email3;

    @Value("${mail.sender1.password}")
    private String email1Password;

    @Value("${mail.sender2.password}")
    private String email2Password;

    @Value("${mail.sender3.password}")
    private String email3Password;

    public String exec(EmailSendRequestDTO emailSendRequestDTO) {
        String email = emailSendRequestDTO.getEmail();
        if (!email.endsWith(DOMAIN)) {
            return "Invalid email domain";
        }

        String code = String.format("%06d", new Random().nextInt(999999));
        saveCode(email, code);

        EmailAccountDAO account = getOrCreateEmailAccount();

        String currentEmail, currentPassword;
        Long sentMails = account.getSentEmails();
        if (sentMails < EMAIL_LIMIT) {
            currentEmail = email1;
            currentPassword = email1Password;
        } else if (sentMails < EMAIL_LIMIT * 2) {
            currentEmail = email2;
            currentPassword = email2Password;
        } else if (sentMails < EMAIL_LIMIT * 3) {
            currentEmail = email3;
            currentPassword = email3Password;
        } else {
            return "All email send limits exceeded";
        }

        sendEmail(email, "Verification Code", "Your code is: " + code, currentEmail, currentPassword);
        account.setSentEmails(account.getSentEmails() + 1);
        emailAccountRepository.save(account);

        return "Code sent";
    }

    // ... (생략)

    private EmailAccountDAO getOrCreateEmailAccount() {
        EmailAccountDAO account = emailAccountRepository.findById(0L).orElse(new EmailAccountDAO());
        if (account.getId() == null) {
            account.setId(0L);
            emailAccountRepository.save(account);
        }
        return account;
    }

    private void saveCode(String email, String code) {
        EmailCodeDAO verification = new EmailCodeDAO();
        verification.setEmail(email);
        verification.setCode(code);
        emailCodeRepository.save(verification);
    }

    private void sendEmail(String to, String subject, String body, String username, String password) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        // Other mail sender configurations if necessary

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
