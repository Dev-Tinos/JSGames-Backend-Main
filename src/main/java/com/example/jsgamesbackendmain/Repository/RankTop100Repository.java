package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RankTop100Repository extends JpaRepository<RankTop100DAO, Long> {
    // 전체중 Score로 내림차순
    Page<RankTop100DAO> findAllByOrderByTotalRankAsc(Pageable pageable);

    @Query(value = "SELECT user_id\n" +
            // 모든 게임의 1등부터 100등까지의 가중치를 더함
            "     , sum(CASE\n" +
            "               WHEN num <= 10 THEN 450 - (num - 1) * 20\n" +
            "               WHEN num <= 50 THEN 250 - (num - 11) * 5\n" +
            "               ELSE 50 - (num - 51)\n" +
            "    END) AS rank_weight\n" +
            // 모든 게임의 1등부터 100등까지의 가중치를 더한 것을 내림차순으로 정렬
            "    , RANK() over (order by sum(CASE\n" +
            "                                     WHEN num <= 10 THEN 450 - (num - 1) * 20\n" +
            "                                     WHEN num <= 50 THEN 250 - (num - 11) * 5\n" +
            "                                     ELSE 50 - (num - 51)\n" +
            "        END) desc) AS total_rank\n" +
            // 서브쿼리
            "from (SELECT l.game_id,\n" +
            "             l.user_id,\n" +
            "             ROW_NUMBER() OVER (PARTITION BY l.game_id ORDER BY\n" +
            // 게임의 점수 타입이 INFINITE이면 게임의 점수를 내림차순으로 정렬
            "                 CASE WHEN g.score_type = 'INFINITE' THEN l.game_score END desc,\n" +
            // 게임의 점수 타입이 GOAL이면 목표 점수와 게임의 점수의 차이를 오름차순으로 정렬
            "                 CASE WHEN g.score_type = 'GOAL' THEN abs(g.target_score - l.game_score) END asc\n" +
            "                 ,l.log_id\n" +
            "                 ) AS num\n" +
            "      FROM logs l\n" +
            "               join games g on l.game_id = g.game_id) as n\n" +
            // 100등까지의 게임의 점수를 더함
            "where num <= 100\n" +
            // user_id로 그룹화
            "group by user_id\n" +
            // 가중치를 내림차순으로 정렬
            "order by rank_weight desc\n" +
            // 100개만 가져옴
            "limit 100;", nativeQuery = true)
    List<Map<String ,String >> findAllByOrderByRankWeightDesc();

}
