package com.example.jsgamesbackendmain.Model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class ResultDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private Long userId;
    private Long gameId;
    private Double gameScore;
}