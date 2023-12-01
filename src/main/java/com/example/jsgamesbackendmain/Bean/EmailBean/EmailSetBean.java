package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailAppendSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailClearSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSetBean {
    @Autowired
    private EmailAppendSmallBean emailAppendSmallBean;
    @Autowired
    private EmailClearSmallBean emailClearSmallBean;
    @Scheduled(cron = "0 55 23 * * *")
    public void exec(){
        emailClearSmallBean.exec();
        emailAppendSmallBean.exec();
    }
}
