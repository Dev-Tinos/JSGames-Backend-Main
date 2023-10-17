package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailClearBean {
    @Autowired
    private EmailCodeRepository emailCodeRepository;
    @Autowired
    private EmailAccountRepository emailAccountRepository;
    @Scheduled(cron = "0 55 23 * * *")
    public void exec(){
        emailAccountRepository.deleteAll();
        emailCodeRepository.deleteAll();
    }
}
