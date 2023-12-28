package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "helpful")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelpfulDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long helpfulId;

    @Setter
    private String userId;
    @Setter
    private Long reviewId;

    @Builder.Default
    private LocalDateTime helpfulTime = LocalDateTime.now();
}
