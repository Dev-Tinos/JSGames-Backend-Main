package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetPageSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserTop100SaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserWeightSaveSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSetTop100Bean {
    @Autowired
    private UserTop100ClearBean userTop100ClearBean;
    @Autowired
    private GameGetPageSmallBean gameGetPageSmallBean;
    @Autowired
    private UserWeightSaveSmallBean userWeightSaveSmallBean;
    @Autowired
    private UserTop100SaveSmallBean userTop100SaveSmallBean;


    // 매일 오후 11시 40분에 실행
    //게임의 1등 부터 100등까지 가중치를 주어 게임마다 top100유저들에게 가중치를 부여 하여 연산
    @Scheduled(cron = "0 50 23 * * *")
    public void exec() {
        // UserTop100DAO를 모두 삭제, UserWeightDAO를 모두 삭제
        userTop100ClearBean.exec();

        //10개씩 Game을 조회하고
        //각 Game에 대해서 1등부터 100등까지의 User들을 조회하여
        Pageable pageable = PageRequest.of(0, 10);
        Page<GameDAO> page;
        do {
            // Game들을 조회
            page = gameGetPageSmallBean.exec(pageable);
            List<GameDAO> gameDAOList = page.toList();

            // GameDAOS 을 UserWeightDAO 에 가중치를 부여
            userWeightSaveSmallBean.exec(gameDAOList);

            // 다음 Game pageable을 다음 페이지로 변경
            pageable = page.nextPageable();

        // 다음 페이지가 존재하지 않으면 반복문 종료
        } while(page.hasNext());

        // UserWeightDTO를 조회하여 userTop100에 저장
        userTop100SaveSmallBean.exec();
    }
}
