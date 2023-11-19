package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RankRepository extends JpaRepository<RankTop100DAO, Long> {
    // 전체중 Score로 내림차순
    Page<RankTop100DAO> findAllByOrderByTotalRankAsc(Pageable pageable);

    @Query(value = "SELECT user_id\n" +
            "     , sum(CASE\n" +
            "               WHEN num <= 10 THEN 450 - (num - 1) * 20\n" +
            "               WHEN num <= 50 THEN 250 - (num - 11) * 5\n" +
            "               ELSE 50 - (num - 51)\n" +
            "    END) AS rank_weight\n" +
            "    , RANK() over (order by sum(CASE\n" +
            "                                     WHEN num <= 10 THEN 450 - (num - 1) * 20\n" +
            "                                     WHEN num <= 50 THEN 250 - (num - 11) * 5\n" +
            "                                     ELSE 50 - (num - 51)\n" +
            "        END) desc) AS total_rank\n" +
            "from (SELECT l.game_id,\n" +
            "             l.user_id,\n" +
            "             ROW_NUMBER() OVER (PARTITION BY l.game_id ORDER BY\n" +
            "                 CASE WHEN g.score_type = 'INFINITE' THEN l.game_score END desc,\n" +
            "                 CASE WHEN g.score_type = 'GOAL' THEN abs(g.target_score - l.game_score) END asc\n" +
            "                 ,l.log_id\n" +
            "                 ) AS num\n" +
            "      FROM logs l\n" +
            "               join games g on l.game_id = g.game_id) as n\n" +
            "where num <= 100\n" +
            "group by user_id\n" +
            "order by rank_weight desc\n" +
            "limit ?1 offset ?2", nativeQuery = true)
    List<Map<String ,String >> findAllByOrderByRankWeightDesc(Integer limit, Integer offset);

}
