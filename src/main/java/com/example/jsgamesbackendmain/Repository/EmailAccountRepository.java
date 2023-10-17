package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAccountRepository extends JpaRepository<EmailAccountDAO, Long> {
    EmailAccountDAO findTopByOrderBySentEmailsAsc();
}
