package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmailCodeCheckBean {

    @Autowired
    private EmailCodeRepository emailCodeRepository;

    public boolean exec(EmailCodeRequestDTO emailCodeRequestDTO){
        String email = emailCodeRequestDTO.getEmail();
        String code = emailCodeRequestDTO.getCode();

        // 가장 최근에 생성된 인증 코드를 가져옵니다.
        List<EmailCodeDAO> codes = emailCodeRepository.findAllCodesByEmailOrderByExpiryDateDesc(email);

        EmailCodeDAO latestCodeEntry = codes.get(0);

        if (latestCodeEntry == null) {
            return false; // 이메일에 해당하는 코드가 없음
        }

        // 코드가 만료되었는지 확인합니다.
        //if (latestCodeEntry.getExpiryDate().isBefore(LocalDateTime.now())) {
        //    return "Code has expired"; // 코드가 만료됨
        //}

        // 클라이언트로부터 받은 코드와 저장된 코드를 비교합니다.
        if (!latestCodeEntry.getCode().equals(code)) {
            return false; // 코드 불일치
        }

        // 여기까지 문제가 없다면, 인증 코드가 유효합니다.
        return true; // 코드가 유효함
    }
}
