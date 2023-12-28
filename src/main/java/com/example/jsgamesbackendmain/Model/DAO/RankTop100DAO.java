package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
