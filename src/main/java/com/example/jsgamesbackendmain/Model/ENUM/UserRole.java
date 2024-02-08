package com.example.jsgamesbackendmain.Model.ENUM;

public enum UserRole {
    USER("유저"), ADMIN("관리자"), PARTNER("후원자");
    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
