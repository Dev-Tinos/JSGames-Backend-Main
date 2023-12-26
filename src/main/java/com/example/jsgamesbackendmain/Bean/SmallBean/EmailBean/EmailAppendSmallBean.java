package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailAppendSmallBean {
    private final EmailAccountRepository emailAccountRepository;

    public void exec() {
        EmailAccountDAO emailAccountDAO = new EmailAccountDAO();
        emailAccountDAO.setSentEmails(1L);
        emailAccountDAO.setId(0L);
        emailAccountRepository.save(emailAccountDAO);
    }
}
