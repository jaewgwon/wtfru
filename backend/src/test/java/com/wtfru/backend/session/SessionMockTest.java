package com.wtfru.backend.session;

import com.wtfru.backend.controller.SessionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SessionMockTest {
    @Autowired
    SessionController sc;
    MockMvc mock;

    String jsonBodySc200Expected = "{" +
            "\"title\": \"someTitle\"," +
            "\"password\": \"1234\"," +
            "\"expired_date\": \"2021/8/31\"" +
            "}";
    String jsonBodySc409Expected = "{" +
            "\"title\": \"mooyaho\"," +
            "\"password\": \"1234\"," +
            "\"expired_date\": \"2021/8/31\"" +
            "}";
    String jsonBodySc422Expected = "{" +
            "\"title\": \"someTitle\"," +
            "\"password\": \"a234\"," +
            "\"expired_date\": \"2021/8/31\"" +
            "}";


    @BeforeEach
    void setUp() {
        System.out.println("initializing before test run");
        mock = MockMvcBuilders.standaloneSetup(sc).build();
    }

    @Test
    @Transactional
    @DisplayName("SessionController test - expected success")
    void testControllerSuccess() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/api/session")
                    .param("password", "true")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(jsonBodySc200Expected))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    @DisplayName("SessionController test - expected 409 conflict")
    void testController409Conflict() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/api/session")
                .param("password", "true")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(jsonBodySc409Expected))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(409));
    }

    @Test
    @Transactional
    @DisplayName("SessionController test - expected 422 unprocessable entity")
    void testController404NotFound() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/api/session")
                .param("password", "true")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(jsonBodySc422Expected))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(422));
    }
}
