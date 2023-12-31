package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.EmailCodeDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailCodeRepository extends JpaRepository<EmailCodeDAO, Long> {
    Optional<EmailCodeDAO> findByEmail(String email);

    boolean existsByEmail(String email);
}