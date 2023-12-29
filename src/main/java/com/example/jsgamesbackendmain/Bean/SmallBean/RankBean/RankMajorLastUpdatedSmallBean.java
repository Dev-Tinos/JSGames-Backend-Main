package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RankMajorLastUpdatedSmallBean {
    private LocalDateTime lastUpdated = LocalDateTime.now();
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }
}
