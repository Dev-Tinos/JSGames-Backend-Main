package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameDAO, Long> {

    Page<GameDAO> findAll(Pageable pageable);
}