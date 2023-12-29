package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
@Getter
public class GameDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String gameName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @Builder.Default
    private List<ReviewDAO> reviews = new ArrayList<>();

    @Builder.Default
    private String gameImage = "https://pbs.twimg.com/media/EA9UJBjU4AAdkCm.jpg";
    private String gameUrl;
    @Setter
    private Double targetScore;
    @Enumerated(EnumType.STRING)
    @Setter
    private ScoreType scoreType;
    private String description;

    //조회수
    private Long viewCount = 0L;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    @Builder.Default
    private List<LogDAO> logs = new ArrayList<>();

    public void setUser(UserDAO user) {
        this.user = user;

        List<GameDAO> games = user.getGames();

        if (!games.contains(this))
            games.add(this);
    }

    public Long increaseViewCount() {
        return ++viewCount;
    }

    public static GameDAO createTest(int i, UserDAO user) {
        GameDAO newGame = GameDAO.builder()
                .gameName(String.valueOf(i))
                .gameUrl(String.valueOf(i))
                .targetScore((double) (i * 3 % 100))
                .scoreType(ScoreType.values()[i % ScoreType.values().length])
                .description(String.valueOf(i))
                .viewCount(((long) i))
                .build();

        newGame.setUser(user);

        return newGame;
    }
}