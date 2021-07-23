package com.wtfru.backend.session;

import com.wtfru.backend.controller.TestController;
import com.wtfru.backend.session.dao.SessionDAO;
import com.wtfru.backend.session.dto.SessionDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SessionTest {
    @Autowired
    TestController ts;
    @MockBean
    private SessionDAO sessionDAO;

    @Test
    @DisplayName("select session where session_id = 1")
    void testSelect() {
        //given
        String uid = "d6b6e033-78f8-4a1d-b986-dbf6baa7402c";
        int sessionId = 1;
        String title = "mooyaho";
        String password = "1234";
        String locationLink = "https://1234";
        int status = 0;

        SessionDTO session = new SessionDTO(uid, sessionId, title, password, locationLink, status);

        BDDMockito.given(sessionDAO.selectSession(1)).willReturn(session);

        SessionDTO responseSession = sessionDAO.selectSession(1);

        org.assertj.core.api.Assertions.assertThat(responseSession).isEqualTo(session);
    }

    @Test
    @Transactional
    @DisplayName("insert session")
    void testInsert() throws Exception {
        String title = "someTitle";
        String password = "1234";
        String locationLink = "someLink";
        SessionDTO session = new SessionDTO();

        sessionDAO.insertSession(title, password, locationLink);
        Mockito.verify(sessionDAO).insertSession(title, password, locationLink);
    }

}
