package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "email_account")
@Getter @Setter
public class EmailAccountDAO {

    @Id
    private Long id;
    private Long sentEmails;

    // ... getters & setters
}
