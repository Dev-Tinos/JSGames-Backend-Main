package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class EmailCodeCheckBean {

    @Autowired
    private EmailCodeRepository emailCodeRepository;

    public boolean exec(EmailCodeRequestDTO emailCodeRequestDTO){
        String email = emailCodeRequestDTO.getEmail();
        String code = emailCodeRequestDTO.getCode();

        // 가장 최근에 생성된 인증 코드를 가져옵니다.
        Optional<EmailCodeDAO> emailCodeDAO = emailCodeRepository.findByEmail(email);
        if (emailCodeDAO.isPresent()) {
            return false;
        }

        // 클라이언트로부터 받은 코드와 저장된 코드를 비교합니다.
        if (!emailCodeDAO.get().getCode().equals(code)) {
            return false;
        }

        // 여기까지 문제가 없다면, 인증 코드가 유효합니다.
        return true;
    }
}
