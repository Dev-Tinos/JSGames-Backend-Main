package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailClearSmallBean {
    @Autowired
    private EmailCodeRepository emailCodeRepository;
    @Autowired
    private EmailAccountRepository emailAccountRepository;

    public void exec() {
        emailCodeRepository.deleteAll();
        emailAccountRepository.deleteAll();
    }
}
