package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserWeightDAO;
import com.example.jsgamesbackendmain.Repository.UserWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserWeightSaveSmallBean {
    @Autowired
    private UserWeightRepository userWeightRepository;
    @Autowired
    private ResultGetByGameIdSmallBean resultGetByGameIdSmallBean;

    public void exec(List<GameDAO> gameDAOList) {
        for(GameDAO gameDAO : gameDAOList) {
            // 각 Game에 대해서 Top100 Result 들을 조회
            List<ResultDAO> resultList = resultGetByGameIdSmallBean.exec(gameDAO, 0L, 100L);

            // 각 User들에게 가중치를 부여
            for(int rank = 1; rank <= resultList.size(); rank++) {
                // i번째 User의 Result를 조회
                ResultDAO resultDAO = resultList.get(rank - 1);

                UserWeightDAO weightDAO = new UserWeightDAO(null, rank, resultDAO.getUserId(), resultDAO.getGameId(), resultDAO.getResultId(), getWeight(rank));
                userWeightRepository.save(weightDAO);
            }
        }
    }
    public long getWeight(int rank) {

        long weight;

        // 1등부터 10등까지 20씩 감소하며 가중치를 부여
        if (rank <= 10) {
            weight = 450 - (rank - 1) * 20L;
        }
        // 11등 부터 50등까지 5씩 감소하며 가중치를 부여
        else if (rank <= 50) {
            weight = 250 - (rank - 11) * 5L;
        }
        // 51등부터 100등까지 1씩 감소하며 가중치를 부여
        else {
            weight = 50 - (rank - 51);
        }
        return weight;
    }
}
