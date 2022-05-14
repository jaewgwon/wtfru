package com.wtfru.backend.status;

import com.wtfru.backend.dao.SessionDAO;
import com.wtfru.backend.dao.StatusDAO;
import com.wtfru.backend.service.StatusService;
import com.wtfru.backend.dto.SessionDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StatusTest {
    @Autowired
    StatusService statusService;
    @MockBean
    private StatusDAO statusDAO;
    @MockBean
    private SessionDAO sessionDAO;

    @Test
    @DisplayName("Test StatusService")
    void testStatusService() {
        // given
        String uid = "d6b6e033-78f8-4a1d-b986-dbf6baa7402c";
        int sessionId = 1;
        String title = "mooyaho";
        String password = "1234";
        String locationLink = "https://1234";
        int status = 0;
        int newStatus = 1;

        SessionDTO givenSession = new SessionDTO(uid, sessionId, title, password, locationLink, status);
        SessionDTO expectedSession = new SessionDTO(uid, sessionId, title, password, locationLink, newStatus);

        BDDMockito.given(statusDAO.update(uid, newStatus)).willReturn(true);
        BDDMockito.given(sessionDAO.getByUid(uid)).willReturn(expectedSession);

        // when
        boolean serviceResult = statusDAO.update(uid, newStatus);
        SessionDTO returnedSession = sessionDAO.getByUid(uid);

        // then
        Assertions.assertThat(serviceResult).isEqualTo(true);
        Assertions.assertThat(returnedSession).isEqualTo(expectedSession);
    }
}
