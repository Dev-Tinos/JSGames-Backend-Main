package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "UserTop100")
public class UserTop100DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long top100Id;

    private Long userId;

    private Long score;
}
