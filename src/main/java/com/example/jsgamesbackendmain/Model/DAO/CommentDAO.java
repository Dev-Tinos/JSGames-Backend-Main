package com.example.jsgamesbackendmain.Model.DAO;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long userId;
    private Long gameId;
    private String commentContent;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;
}
