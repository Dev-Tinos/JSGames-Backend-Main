package com.example.jsgamesbackendmain.Bean.EmailBean;

import com.example.jsgamesbackendmain.Model.DTO.Email.EmailSendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.EmailAccountRepository;
import com.example.jsgamesbackendmain.Repository.EmailCodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class EmailBeanTest {
    @Autowired
    private EmailCodeRepository emailCodeRepository;
    @Autowired
    private EmailAccountRepository emailAccountRepository;

    @Autowired
    private SetEmail emailSetBean;

    @Test
    void EmailSetBeanTest() {
        //given
        //when
        emailSetBean.exec();
        //then
        assertEquals(0, emailCodeRepository.count());
        assertEquals(1, emailAccountRepository.count());
        assertEquals(1, emailAccountRepository.findById(0L).get().getSentEmails());
    }

    @Autowired
    private SendEmail emailSendBean;

    @Test
    void EmailSendBeanTest() {
        //given
        String email = "test@tukorea.ac.kr";
        EmailSendRequestDTO newEmailSendRequestDTO
                = EmailSendRequestDTO.builder()
                .email(email)
                .build();

        //when
        emailSetBean.exec();
        StateResponseDTO stateResponseDTO = emailSendBean.exec(newEmailSendRequestDTO);

        //then
        assertEquals(1, emailCodeRepository.count());
        assertEquals(1, emailAccountRepository.count());
        assertTrue(stateResponseDTO.isState());
    }


}
