package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter @Setter
@ToString
public class ReviewDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private Long userId;
    private Long gameId;
    private String reviewContent;

    // 별점
    private Float star;

    // helpful
    private Float helpful;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;
}
