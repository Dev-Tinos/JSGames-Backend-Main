package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

import javax.persistence.*;

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

    @Setter
    private String userId;

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

    public Long increaseViewCount() {
        return ++viewCount;
    }

    public static GameDAO createTest(int i) {
        return GameDAO.builder()
                .gameName(String.valueOf(i))
                .gameUrl(String.valueOf(i))
                .targetScore((double) (i * 3 % 100))
                .scoreType(ScoreType.values()[i % ScoreType.values().length])
                .description(String.valueOf(i))
                .viewCount(((long) i))
                .build();
    }
}