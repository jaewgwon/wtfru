package com.wtfru.backend.location;

import com.wtfru.backend.controller.LocationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class LocationMockTest {
    @Autowired
    LocationController lc;
    MockMvc mock;

    String jwt = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lVGl0bGUxNSIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE5" +
            "ODkzNzMxMTN9.AdbtTVx0PRahdcpeI52XwupkK7cmC3WZp9NZ5DXgW9XC3Do7377gQ1IJgm1-GXUnStxLIx_bd0ODV1edwR-3Ag";

    String jwt2 = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb21lVGl0bGUxNyIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2N" +
            "jU0NTcwNzF9.QwvYnQmRukq9AaOJcEXAS-R0XYR8uCAzsLtq7SAWyf1ttjWxqnbBpX0Ngg6p2AwMT5AHbzGaO9TBMO7SwGzJVA";

    String jsonBodyForPost200 = "{" +
            "\"latitude\": \"31.4321\"," +
            "\"longitude\": \"123.1234\"" +
            "}";

    String jsonBodyForPatch200 = "{" +
            "\"uid\": \"7146e455-5b91-4883-8d1e-149c7535a595\"," +
            "\"latitude\": \"0.123\"," +
            "\"longitude\": \"4.321\"" +
            "}";


    @BeforeEach
    void setUp() {
        System.out.println("initializing before test run");
        mock = MockMvcBuilders.standaloneSetup(lc).build();
    }

    @Test
    @Transactional
    @DisplayName("POST location test - 200 expected")
    void testPostControllerSuccess() throws Exception {
        mock.perform(MockMvcRequestBuilders.post("/api/session/location")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .content(jsonBodyForPost200)
                    .header(HttpHeaders.AUTHORIZATION, jwt2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    @DisplayName("GET location test - 200 expected")
    void testGetControllerSuccess() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/api/session/location")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .header(HttpHeaders.AUTHORIZATION, jwt))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Transactional
    @DisplayName("PATCH location test - 200 expected")
    void testPatchControllerSuccess() throws Exception {
        mock.perform(MockMvcRequestBuilders.patch("/api/session/location")
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8")
                    .header(HttpHeaders.AUTHORIZATION, jwt)
                    .content(jsonBodyForPatch200))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
