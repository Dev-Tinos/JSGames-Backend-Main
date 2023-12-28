package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Model.DTO.Email.EmailCodeRequestDTO;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmailCodeCheckSmallBean {

    private final EmailCodeRepository emailCodeRepository;

    public void exec(EmailCodeRequestDTO emailCodeRequestDTO) {
        String email = emailCodeRequestDTO.getEmail();
        String code = emailCodeRequestDTO.getCode();

        // 가장 최근에 생성된 인증 코드를 가져옵니다.
        Optional<EmailCodeDAO> emailCodeDAO = emailCodeRepository.findByEmail(email);
        if (!emailCodeDAO.isPresent()) {
            throw new InvalidException("해당 메일로 메일이 발송되지 않았습니다.");
        }

        // 클라이언트로부터 받은 코드와 저장된 코드를 비교합니다.
        if (!emailCodeDAO.get().getCode().equals(code)) {
            throw new InvalidException("잘못된 코드입니다.");
        }
    }
}
