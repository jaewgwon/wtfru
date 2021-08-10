package com.wtfru.backend.status;

import com.wtfru.backend.service.StatusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StatusTest {
    @Autowired
    StatusService statusService;

    @Test
    void testPutStatus() {
        //given
        String uid
    }
}
