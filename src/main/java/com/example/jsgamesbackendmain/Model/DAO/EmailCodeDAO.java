package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_code")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailCodeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String code;

    @Builder.Default
    private LocalDateTime expiryDate = LocalDateTime.now();

    // ... getters & setters
}
