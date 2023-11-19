package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RankLastUpdatedSmallBean {
    private LocalDateTime lastUpdated = LocalDateTime.now();
    public LocalDateTime exec() {
        return lastUpdated;
    }
    public void setLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }
}
