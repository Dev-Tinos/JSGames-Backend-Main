package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailAppendSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.EmailBean.EmailClearSmallBean;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSetBean {
    private final EmailAppendSmallBean emailAppendSmallBean;
    private final EmailClearSmallBean emailClearSmallBean;
    @Scheduled(cron = "0 55 23 * * *")
    public void exec(){
        emailClearSmallBean.exec();
        emailAppendSmallBean.exec();
    }
}
