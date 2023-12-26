package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailAccoutPlusSmallBean {
    private final EmailAccountRepository emailAccountRepository;

    public void exec() {
        emailAccountRepository.updateSentEmailsPlus(0L);
    }
}
