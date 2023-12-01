package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailAccoutPlusSmallBean {
    @Autowired
    private EmailAccountRepository emailAccountRepository;

    public void exec(){
        emailAccountRepository.updateSentEmailsPlus(0L);
    }
}
