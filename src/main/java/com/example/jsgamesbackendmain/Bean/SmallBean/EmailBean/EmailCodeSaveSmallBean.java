package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailCodeSaveSmallBean {
    private final EmailCodeRepository emailCodeRepository;

    public void exec(String Email, String verificationCode) {
        // 인증 코드 저장
        EmailCodeDAO newCode = EmailCodeDAO.builder()
                .email(Email)
                .code(verificationCode)
                .build();

        emailCodeRepository.save(newCode);
    }
}
