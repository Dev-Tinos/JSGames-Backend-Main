package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTop100Repository extends JpaRepository<UserTop100DAO, Long> {
    // 전체중 Score로 내림차순
    Page<UserTop100DAO> findAllByOrderByScoreDesc(Pageable pageable);

}
