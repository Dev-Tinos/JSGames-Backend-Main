package com.example.jsgamesbackendmain.Model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nickname;
    private String email;
    private String password;
    private String major;
}
