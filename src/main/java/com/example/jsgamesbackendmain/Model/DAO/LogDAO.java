package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Logs")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Setter
    private String userId;
    @Setter
    private Long gameId;
    private Double gameScore;

    public static LogDAO createTest(int i) {
        return LogDAO.builder()
                .gameScore((double) i)
                .build();
    }
}