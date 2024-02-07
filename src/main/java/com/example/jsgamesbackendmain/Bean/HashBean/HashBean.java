package com.example.jsgamesbackendmain.Bean.HashBean;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class HashBean {
    public static String createHash(String origin) {
        return Hashing.sha256().hashString(origin, StandardCharsets.UTF_8).toString();
    }

    // 해시 비교
    public static boolean isMatch(String origin, String hashed) {
        return createHash(origin).equals(hashed);
    }
}
