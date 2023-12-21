package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDAO, Long> {

    //gameId 로 review의 star 평균
    @Query("SELECT AVG(r.star) FROM ReviewDAO r WHERE r.gameId = ?1")
    Optional<Double> findAvgStarByGameId(Long gameId);

    //userId 와 gameId 로 review 찾기
    Optional<ReviewDAO> findByUserIdAndGameId(String userId, Long gameId);
    //reviewID 의 helpful +1
    @Modifying
    @Query("UPDATE ReviewDAO r SET r.helpful = r.helpful + 1 WHERE r.reviewId = ?1")
    void updateHelpfulPlus(Long reviewId);

    //reviewID 의 helpful -1
    @Modifying
    @Query("UPDATE ReviewDAO r SET r.helpful = r.helpful - 1 WHERE r.reviewId = ?1")
    void updateHelpfulMinus(Long reviewId);


    Page<ReviewDAO> findByGameIdOrderByHelpfulDescDateTimeDescReviewIdDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByStarDescDateTimeDescReviewIdDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeDescReviewIdDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeAscReviewIdDesc(Long gameId, Pageable pageable);
}