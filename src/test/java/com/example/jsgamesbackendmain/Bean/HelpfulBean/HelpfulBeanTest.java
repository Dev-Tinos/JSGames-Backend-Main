package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetReponseDTO;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class HelpfulBeanTest {
    @Autowired
    private HelpfulRepository helpfulRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HelpfulGetBean helpfulGetBean;
    @Test
    void HelpfulGetBeanTest() {
        //given
        HelpfulDAO helpfulDAO = new HelpfulDAO();
        helpfulDAO.setUserId("test01");
        helpfulDAO.setReviewId(1L);
        helpfulRepository.save(helpfulDAO);

        //when
        HelpfulGetReponseDTO helpfulGetReponseDTO1 = helpfulGetBean.exec("test01", 1L);
        HelpfulGetReponseDTO helpfulGetReponseDTO2 = helpfulGetBean.exec("test02", 1L);
        //then
        assertTrue(helpfulGetReponseDTO1.isHelpful());
        assertFalse(helpfulGetReponseDTO2.isHelpful());
    }

    @Autowired
    private HelpfulPostBean helpfulPostBean;
    @Test
    void HelpfulPostBeanTest() {
        //given
        ReviewDAO newReview = ReviewDAO.createTest(1);
        reviewRepository.save(newReview);

        //when
        helpfulPostBean.exec("test01", 1L);
        helpfulPostBean.exec("test02", 1L);
        //then
        assertEquals(2, helpfulRepository.count());
    }

    @Autowired
    private HelpfulDeleteBean helpfulDeleteBean;
    @Test
    void HelpfulDeleteBeanTest() {
        //given
        ReviewDAO newReview = ReviewDAO.createTest(1);
        reviewRepository.save(newReview);
        helpfulPostBean.exec("test01", 1L);
        helpfulPostBean.exec("test02", 1L);
        //when
        helpfulDeleteBean.exec("test01", 1L);
        helpfulDeleteBean.exec("test02", 1L);
        //then
        assertEquals(0, helpfulRepository.count());
    }
}
