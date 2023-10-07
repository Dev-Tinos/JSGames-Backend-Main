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
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;

    //조회수
    private Long viewCount = 0L;
}