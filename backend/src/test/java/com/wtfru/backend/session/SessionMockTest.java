package com.wtfru.backend.session;

import com.wtfru.backend.controller.TestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SessionMockTest {
    @Autowired
    TestController ts;

    MockMvc mock;
    @BeforeEach
    void setUp() {
        System.out.println("initializing before test run");
        mock = MockMvcBuilders.standaloneSetup(ts).build();
    }

    @Test
    @Transactional
    @DisplayName("insert session")
    void testInsert() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/test"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
