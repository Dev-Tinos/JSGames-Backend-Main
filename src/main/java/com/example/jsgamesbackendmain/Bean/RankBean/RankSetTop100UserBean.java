package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetPageSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankWeightSaveSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RankSetTop100UserBean {
    @Autowired
    private RankTop100ClearBean rankTop100ClearBean;
    @Autowired
    private GameGetPageSmallBean gameGetPageSmallBean;
    @Autowired
    private RankWeightSaveSmallBean rankWeightSaveSmallBean;
    @Autowired
    private RankSaveSmallBean rankSaveSmallBean;


    // 매일 오후 11시 40분에 실행
    //게임의 1등 부터 100등까지 가중치를 주어 게임마다 Top100유저들에게 가중치를 부여 하여 연산
    @Scheduled(cron = "0 50 23 * * *")
    public void exec() {
        // RankTop100DAO를 모두 삭제, RankWeightDAO를 모두 삭제
        rankTop100ClearBean.exec();

        //10개씩 Game을 조회하고
        //각 Game에 대해서 1등부터 100등까지의 User들을 조회하여
        Pageable pageable = PageRequest.of(0, 10);
        Page<GameDAO> page;
        do {
            // Game들을 조회
            page = gameGetPageSmallBean.exec(pageable);
            List<GameDAO> gameDAOList = page.toList();

            // GameDAOS 을 rankWeightDAO 에 가중치를 부여
            rankWeightSaveSmallBean.exec(gameDAOList);

            // 다음 Game pageable을 다음 페이지로 변경
            pageable = page.nextPageable();

        // 다음 페이지가 존재하지 않으면 반복문 종료
        } while(page.hasNext());

        // rankWeightDTO를 조회하여 rankTop100에 저장
        rankSaveSmallBean.exec();
    }
}
