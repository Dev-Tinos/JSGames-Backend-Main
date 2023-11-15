package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    private String nickname;
    private String email;
    private String password;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    private ParentMajor parentMajor;
    @Enumerated(EnumType.STRING)
    private Major major;
}
