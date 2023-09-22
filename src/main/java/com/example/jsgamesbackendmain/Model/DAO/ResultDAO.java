package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "results")
@Getter @Setter
public class ResultDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    private Long userId;
    private Long gameId;
    private Double gameScore;
}