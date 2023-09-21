package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String nickname;
    private String email;
    private String password;
    private String major;
}
