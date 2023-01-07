package com.example.practice66ezhikov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class Practice66EzhikovApplicationTests {
    @Test
    void contextLoads(ApplicationContext context) {
        Assertions.assertNotNull(context);
    }
}
