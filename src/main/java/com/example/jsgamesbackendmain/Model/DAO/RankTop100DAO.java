package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString
@Table(name = "RankTop100")
public class RankTop100DAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankId;

    private String userId;
    private Integer totalRank;
    private Long rankWeight;
}
