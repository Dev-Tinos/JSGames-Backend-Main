package com.example.jsgamesbackendmain;

import com.example.jsgamesbackendmain.Bean.UserBean.GetUserByUserId;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
// MockMvc를 사용하기 위한 어노테이션
@AutoConfigureMockMvc
// 테스트 코드가 끝나면 롤백을 해줌
@Transactional
class JsGamesBackendMainApplicationTests {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GetUserByUserId userGetBean;

//    @Test
//    void ObjectMapper_예시코드() throws Exception {
//        ReviewDAO dao = ReviewDAO.createTest(0);
//
//        // DTO를 JSON 직렬화
//        String s = objectMapper.writeValueAsString(dao);
//
//        System.out.println(s);
//
//        // JSON을 DTO 역직렬화
//        ReviewDTO dto2 = objectMapper.readValue(s, ReviewDTO.class);
//
//        // DTO를 DAO로 변환
//        ReviewDAO reviewDAO = objectMapper.convertValue(dto2, ReviewDAO.class);
//
//        System.out.println(reviewDAO);
//
//        System.out.println(dto2);
//    }

//    @Test
//    void MockMvc_Test_예시코드() throws Exception {
//        // MockMvc를 사용하여 테스트 코드 작성
//        String s = mockMvc.perform(
//                        MockMvcRequestBuilders.get("/api/user/0")
//                                .contentType("application/json")
//                )
//                // 응답 코드가 404인지 확인
//                .andExpect(MockMvcResultMatchers.status().is(404))
//                // 응답 본문을 받아서 String으로 변환
//                .andReturn().getResponse().getContentAsString();
//
//        System.out.println(s);
//
//        // String을 Map으로 변환
//        Map<String ,String > map  = objectMapper.readValue(s, Map.class);
//
//        System.out.println(map);
//
//        // Map의 key가 message인지 확인
//        assertTrue(map.containsKey("message"));
//
//        // Map의 message가 "User not found for this id :: 1"인지 확인
//        assertEquals(map.get("message"), "User not found for this id :: 0");
//    }

//    @Test
//    void UserGetBean_Test_예시코드() {
//        // UserGetBean을 사용하여 테스트 코드 작성
//        String message = "";
//
//         try {
//             userGetBean.getUser(0L);
//         } catch (Exception e) {
//            message = e.getMessage();
//         }
//         assertEquals(message, "User not found for this id :: 0");
//    }
}
