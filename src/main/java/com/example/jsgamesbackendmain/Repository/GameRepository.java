package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.GameDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameDAO, Long> {
}