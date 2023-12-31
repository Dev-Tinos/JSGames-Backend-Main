package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Logs")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameDAO game;

    private Double gameScore;

    public void setUser(UserDAO user) {
        this.user = user;

        List<LogDAO> logs = user.getLogs();

        if (!logs.contains(this))
            logs.add(this);
    }

    public void setGame(GameDAO game) {
        this.game = game;

        List<LogDAO> logs = game.getLogs();

        if (!logs.contains(this))
            logs.add(this);
    }

    public static LogDAO createTest(int i, GameDAO game, UserDAO user) {
        LogDAO newLog = LogDAO.builder()
                .gameScore((double) i)
                .build();

        newLog.setUser(user);
        newLog.setGame(game);

        return newLog;
    }
}