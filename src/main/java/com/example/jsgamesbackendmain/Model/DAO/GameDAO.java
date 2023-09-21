package com.example.jsgamesbackendmain.Model.DAO;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class GameDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private String description;
}