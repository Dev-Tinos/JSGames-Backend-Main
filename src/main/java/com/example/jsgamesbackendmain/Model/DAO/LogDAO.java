package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Logs")
@Getter @Setter
public class LogDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private Long userId;
    private Long gameId;
    private Double gameScore;
}