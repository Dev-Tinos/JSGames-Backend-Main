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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private ReviewDAO review;

    @Builder.Default
    private LocalDateTime helpfulTime = LocalDateTime.now();

}
