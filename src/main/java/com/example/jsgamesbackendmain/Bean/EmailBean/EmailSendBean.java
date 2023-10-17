package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailDomainCheckSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailMaxCheckSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailSendSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Random;


@Component
public class EmailSendBean {

    @Autowired
    private EmailAccountRepository emailAccountRepository;

    @Autowired
    private EmailCodeRepository emailCodeRepository;

    @Autowired
    private EmailSendSmallBean emailSendSmallBean;

    @Autowired
    private UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    @Autowired
    private EmailMaxCheckSmallBean emailMaxCheckSmallBean;

    @Autowired
    private EmailDomainCheckSmallBean emailDomainCheckSmallBean;

    @Autowired
    private EmailDuplicateSmallBean emailDuplicateSmallBean;

    public String exec(EmailSendRequestDTO emailSendRequestDTO) {
        EmailAccountDAO account = emailAccountRepository.findById(0L).orElse(null);
        String Email = emailSendRequestDTO.getEmail();


        // 이메일 최대 개수 검사
        emailMaxCheckSmallBean.exec(account);
        // 유저 중 이메일 중복 검사
        userEmailDuplicateSmallBean.exec(Email);
        // 이메일을 이미 보냈는지 검사
        emailDuplicateSmallBean.exec(Email);
        // 이메일 도메인 검증
        emailDomainCheckSmallBean.exec(Email);
        // 인증 코드 생성
        String verificationCode = String.format("%06d", new Random().nextInt(999999));

        // 이메일 발송
        emailSendSmallBean.exec(Email, verificationCode);

        // 인증 코드 저장
        EmailCodeDAO newCode = new EmailCodeDAO();
        newCode.setEmail(Email);
        newCode.setCode(verificationCode);
        emailCodeRepository.save(newCode);

        // sentEmails 카운트 업데이트
        if (account == null) {
            account = new EmailAccountDAO();
            account.setId(0L);
            account.setSentEmails(1L);
        } else {
            account.setSentEmails(account.getSentEmails() + 1);
        }
        emailAccountRepository.save(account);

        return "Code sent";
    }
}
