package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "helpful")
@Getter
@Setter
public class HelpfulDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long helpfulId;
    private String userId;
    private Long reviewId;
    private LocalDateTime helpfulTime = LocalDateTime.now();
}
