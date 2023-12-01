package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.EmailAccountDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface EmailAccountRepository extends JpaRepository<EmailAccountDAO, Long> {
    // 이메일 sentEmails +1
    @Modifying
    @Transactional
    @Query("UPDATE EmailAccountDAO e SET e.sentEmails = e.sentEmails + 1 WHERE e.id = ?1")
    void updateSentEmailsPlus(Long id);
}
