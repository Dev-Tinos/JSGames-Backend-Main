package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.ExceededException;
import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import org.springframework.stereotype.Component;

@Component
public class EmailMaxCheckSmallBean {

    private static final int MAX_MAIL = 500;

    public void exec(EmailAccountDAO emailAccountDAO){
        if(emailAccountDAO.getSentEmails()>=MAX_MAIL){
            throw new ExceededException("보낼 수 있는 이메일의 최대 개수를 초과했습니다.");
        }
    }
}
