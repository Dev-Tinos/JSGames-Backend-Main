package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.DuplicateException;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import org.springframework.stereotype.Component;

@Component
public class EmailDomainCheckSmallBean {
    private static final String DOMAIN = "@tukorea.ac.kr";

    public void exec(String mail){
        if (!mail.endsWith(DOMAIN)) {
            throw new InvalidException("잘못된 이메일 주소입니다.");
        }
    }
}
