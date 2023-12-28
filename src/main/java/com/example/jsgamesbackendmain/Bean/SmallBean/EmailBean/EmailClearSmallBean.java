package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailClearSmallBean {
    private final EmailCodeRepository emailCodeRepository;
    private final EmailAccountRepository emailAccountRepository;

    public void exec() {
        emailCodeRepository.deleteAll();
        emailAccountRepository.deleteAll();
    }
}
