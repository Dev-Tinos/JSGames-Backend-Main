package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmailAccountGetSmallBean {

    @Autowired
    private EmailAccountRepository emailAccountRepository;

    public EmailAccountDAO exec(){
        Optional<EmailAccountDAO> account = emailAccountRepository.findById(0L);
        if(!account.isPresent()){
            throw new NullPointerException("EmailAccountDAO가 초기화되지 않습니다.");
        }
        return account.get();
    }
}
