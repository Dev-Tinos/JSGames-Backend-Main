package com.example.jsgamesbackendmain.Model.DTO.Token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccessTokenDTO {
    private String accessToken;
    private Date expiredAt;
    private Date issuedAt;
    private String userId;

    public boolean isExpired() {
        return new Date().after(expiredAt);
    }

    // userId 가 일치하는지 확인
    public boolean isMatchUserId(String userId) {
        return this.userId.equals(userId);
    }

    public boolean isAlmostExpiredByMinutes(int minutes) {
        return (expiredAt.getTime() - new Date().getTime()) < 60L * minutes * 1000;
    }

}
