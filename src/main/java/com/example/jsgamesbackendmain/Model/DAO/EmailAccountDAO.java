package com.example.jsgamesbackendmain.Model.DAO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "email_account")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailAccountDAO {

    @Id
    private Long id;
    @Setter
    private Long sentEmails;

    // ... getters & setters
}
