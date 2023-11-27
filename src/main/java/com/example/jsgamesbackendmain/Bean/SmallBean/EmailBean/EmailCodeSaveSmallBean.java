package com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean;

import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailCodeSaveSmallBean {
    @Autowired
    private EmailCodeRepository emailCodeRepository;

    public void exec(String Email, String verificationCode){
        // 인증 코드 저장
        EmailCodeDAO newCode = new EmailCodeDAO();
        newCode.setEmail(Email);
        newCode.setCode(verificationCode);
        emailCodeRepository.save(newCode);
    }
}
