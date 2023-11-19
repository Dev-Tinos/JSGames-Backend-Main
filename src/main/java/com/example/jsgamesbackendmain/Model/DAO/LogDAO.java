package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Logs")
@Getter @Setter
@ToString
public class LogDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    private String userId;
    private Long gameId;
    private Double gameScore;

    public static LogDAO createTest(int i) {
        LogDAO dao = new LogDAO();
        dao.setGameScore((double) i);
        return dao;
    }
}