package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "RankMajor")
public class RankMajorDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankId;

    private String userId;
    private Integer totalRank;
    private Long rankWeight;
    private Major major;
}