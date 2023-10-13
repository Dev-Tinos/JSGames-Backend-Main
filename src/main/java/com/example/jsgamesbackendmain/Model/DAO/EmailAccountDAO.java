package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class EmailAccountDAO {

    @Id
    private Long id = 0L;
    private Long sentEmails = 0L;

    // ... getters & setters
}
