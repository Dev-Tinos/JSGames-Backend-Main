package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailDuplicateSmallBean {
    private final EmailCodeRepository emailCodeRepository;

    public void exec(String email) {
        if (emailCodeRepository.existsByEmail(email)) {
            throw new DuplicateException("이미 메일 발송이 된 메일주소입니다.");
        }
    }
}
