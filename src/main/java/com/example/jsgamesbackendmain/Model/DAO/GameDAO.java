package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "games")
@Getter @Setter
public class GameDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String gameName;
    private String userId;
    private String gameImage = "https://pbs.twimg.com/media/EA9UJBjU4AAdkCm.jpg";
    private String gameUrl;
    private Double targetScore;
    @Enumerated(EnumType.STRING)
    private ScoreType scoreType;
    private String description;

    //조회수
    private Long viewCount = 0L;

    public static GameDAO createTest(int i) {
        ScoreType[] types = ScoreType.values();
        String s = String.valueOf(i);
        GameDAO dao = new GameDAO();
        dao.setGameName(s);
        dao.setGameImage(s);
        dao.setGameUrl(s);
        dao.setTargetScore((double) (i * 3 % 100));
        dao.setScoreType(types[i % types.length]);
        dao.setDescription(s);
        dao.setViewCount(((long) i));
        return dao;
    }
}