package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameDAO, Long> {

    // 게임 조회수 순으로 정렬
    Page<GameDAO> findAllByOrderByViewCountDesc(Pageable pageable);
}