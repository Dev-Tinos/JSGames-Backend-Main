package com.example.jsgamesbackendmain.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_weight")
public class UserWeightDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userWeightId;

    private int rank;

    private Long userId;

    private Long gameId;

    private Long logId;

    private Long userWeight;
}
