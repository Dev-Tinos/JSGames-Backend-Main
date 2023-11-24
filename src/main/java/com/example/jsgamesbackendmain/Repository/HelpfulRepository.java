package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface HelpfulRepository extends JpaRepository<HelpfulDAO, Long> {
    //userId, reviewId로 조회
    Optional<HelpfulDAO> findByUserIdAndReviewId(String userId, Long reviewId);
    //userId, reviewId로 삭제
    @Transactional
    void deleteByUserIdAndReviewId(String userId, Long reviewId);
}
