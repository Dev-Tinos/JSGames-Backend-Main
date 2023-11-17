package com.example.jsgamesbackendmain.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rank_weight")
public class RankWeightDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankWeightId;

    private int rank;

    private Long userId;

    private Long gameId;

    private Long logId;

    private Long weight;
}
