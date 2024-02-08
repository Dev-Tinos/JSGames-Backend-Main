package com.example.jsgamesbackendmain.Bean.HashBean;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class HashBean {


    private final String salt;

    @Autowired
    public HashBean(
            @Value("${SALT}") String salt
    ) {
        this.salt = salt;
    }

    public static String createHash(String origin) {
        return Hashing.sha256().hashString(origin, StandardCharsets.UTF_8).toString();
    }

    // 비밀번호 일치 여부 확인
    public boolean isMatch(String origin, String hashed) {
        return createHash(origin).equals(hashed);
    }

    // 암호화
    public String encrypt(String origin) {
        return createHash(origin + salt);
    }
}
